package init;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dmitry on 2/27/2015.
 */
public class NQueens {

    public enum Availability {
        available, notAvailable, occupied, notAvailableDirection
    }

    public enum Status {
        done, exceedsSteps, notEffective
    }

    private static class Move {
        final int row;
        final int col;
        final int index;
        final int cost;

        public Move(int row, int col, int index, int cost) {
            this.row = row;
            this.col = col;
            this.index = index;
            this.cost = cost;
        }
    }

    private static class GenerationResult {
        final Status status;
        MoveStep step;
        final int totalCost;
        Move parent;

        public GenerationResult(Status status, int totalCost, Move parent) {
            this.status = status;
            this.totalCost = totalCost;
            this.parent = parent;
        }

        public GenerationResult(Status status,int totalCost,Move parent, MoveStep step) {
            this(status, totalCost, parent);
            this.step = step;
        }
    }

    private static class MoveStep {
        Move move;
        final MoveStep next;

        public  MoveStep (Move move, MoveStep next){
            this.move = move;
            this.next = next;
        }
    }

    private  static  class AtomicCost {
        private volatile int cost = Integer.MAX_VALUE;

        public void replaceIfLess(int value) {
            if (cost > value) {
                cost = value;
            }
        }

        public int getCost() {
            return cost;
        }
    }

    static private class CalculateGenerationTask extends RecursiveTask<GenerationResult> {
        AtomicCost bestCost;
        int[] queenRows;
        int[] queenCols;
        int step;
        int totalCost;
        Move parent;

        CalculateGenerationTask(int[] queenRows, int[] queenCols, int step, int totalCost, AtomicCost bestCost, Move parent){
            this.queenRows = queenRows;
            this.queenCols = queenCols;
            this.step = step;
            this.totalCost = totalCost;
            this.bestCost = bestCost;
            this.parent = parent;
        }

        @Override
        protected GenerationResult compute() {
            if (totalCost > bestCost.getCost()) {
                return new GenerationResult(Status.notEffective, totalCost, parent);
            }

            if (step > 8 * queenRows.length)
                return new GenerationResult(Status.exceedsSteps, totalCost, parent);

            boolean done = true;
            List<Move> generation = new ArrayList<Move>();

            for (int index = 0; index < queenRows.length; index++) {
                int row = queenRows[index];
                int col = queenCols[index];
                if (calculateAvailability(row, col, queenRows, queenCols, index, 0, 0) == Availability.available) {
                    continue;
                }
                done = false;

                for(int dRow = -1; dRow <= 1; dRow++)
                    for(int dCol = -1; dCol <= 1; dCol++)
                        if (dCol !=0 && dRow !=0)
                            generateVariants(index, dRow, dCol, queenRows, queenCols, generation);

            }

            if(done) {
                bestCost.replaceIfLess(totalCost);
                return new GenerationResult(Status.done, totalCost, parent);
            }

            List<ForkJoinTask<GenerationResult>> joins = new ArrayList<ForkJoinTask<GenerationResult>>(generation.size());

            for (Move move : generation) {
                int[] cols = queenCols.clone();
                int[] rows = queenRows.clone();
                cols[move.index] = move.col;
                rows[move.index] = move.row;
                CalculateGenerationTask task = new CalculateGenerationTask(rows, cols, step + 1, totalCost + move.cost, bestCost, move);

                joins.add(task.fork());
            }

            List<GenerationResult> results = new ArrayList<GenerationResult>();
            for(ForkJoinTask<GenerationResult> join : joins) {
                GenerationResult result = join.join();
                if (result.status == Status.done) {
                    result.step = new MoveStep(result.parent, result.step);
                    results.add(result);
                }
            }

            if (results.size() != 0) {
                if (results.size() == 1)
                    return new GenerationResult(Status.done, results.get(0).totalCost, parent, results.get(0).step);
                int minCost = results.get(0).totalCost;
                int minIndex = 0;
                for(int i = 1; i < results.size(); i++) {
                    if (results.get(i).totalCost < minCost) {
                        minCost = results.get(i).totalCost;
                        minIndex = i;
                    }
                }
                return new GenerationResult(Status.done, results.get(minIndex).totalCost, parent, results.get(minIndex).step);
            } else {
                return new GenerationResult(Status.notEffective, totalCost, parent);
            }
        }

        private void generateVariants(int index, int dRow, int dCol, int[] queenRows, int[] queenCols, List<Move> generation) {
            int row = queenRows[index];
            int col = queenCols[index];
            int cost = 0;
            Availability status;
            do {
                col += dCol;
                row += dRow;
                cost++;
                status = calculateAvailability(row, col, queenRows, queenCols, index, dRow, dCol);
            } while (status != Availability.occupied && status != Availability.available && cost < queenRows.length && status!=Availability.notAvailableDirection);
            if (status == Availability.available) {
                generation.add(new Move(row, col, index, cost));
            }
        }

        private Availability calculateAvailability(int row, int col, int[] queenRows, int[] queenCols, int excludeIndex, int dRow, int dCol){
            for(int i = 0; i < queenRows.length; i++) {
                if(excludeIndex == i) continue;
                if(row == queenRows[i] && col == queenCols[i]) return Availability.occupied;
                if(row == queenRows[i]) {
                    if(dRow != 0 && dCol == 0) return Availability.notAvailableDirection;
                    return Availability.notAvailable;
                }
                if(col == queenCols[i]) {
                    if(dRow == 0 && dCol != 0) return Availability.notAvailableDirection;
                    return Availability.notAvailable;
                }
                if(row == col + queenRows[i] - queenCols[i]) {
                    if(dRow == dCol) return Availability.notAvailableDirection;
                    return Availability.notAvailable;
                }
                if(row == - col + queenRows[i] + queenCols[i]) {
                    if(dRow == -dCol) return Availability.notAvailableDirection;
                    return Availability.notAvailable;
                }
            }
            return Availability.available;
        }
    }

    public String[] rearrange(int[] queenRows, int[] queenCols) {
        assert queenRows.length == queenCols.length;
        ForkJoinPool pool = new ForkJoinPool();
        GenerationResult res = pool.invoke(new CalculateGenerationTask(queenRows, queenCols, 0, 0, new AtomicCost(), null));
        List<String> list = new ArrayList<String>();
        MoveStep step = res.step;
        while (step != null) {
            list.add(String.format("%d %d %d", step.move.index, step.move.row, step.move.col));
            step = step.next;
        }
        return list.toArray(new String[0]);
    }


}

