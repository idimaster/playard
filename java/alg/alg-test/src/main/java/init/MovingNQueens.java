package init;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 2/27/2015.
 */
public class MovingNQueens {

    volatile int bestCost;

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

        public GenerationResult(Status status, int totalCost) {
            this.status = status;
            this.totalCost = totalCost;
        }

        public GenerationResult(Status status,int totalCost, MoveStep step) {
            this(status, totalCost);
            this.step = step;
        }

        public Status getStatus() {
            return status;
        }

        public MoveStep getStep() {
            return step;
        }

        public int getTotalCost() {
            return totalCost;
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

    public String[] rearrange(int[] queenRows, int[] queenCols) {
        assert queenRows.length == queenCols.length;
        bestCost = Integer.MAX_VALUE;
        GenerationResult res = calculateGeneration(queenRows, queenCols, 0, 0);
        List<String> list = new ArrayList<String>();
        MoveStep step = res.step;
        while (step != null) {
            list.add(String.format("%d %d %d", step.move.index, step.move.row, step.move.col));
            step = step.next;
        }
        return list.toArray(new String[0]);
    }

    private GenerationResult calculateGeneration(int[] queenRows, int[] queenCols, int step, int totalCost) {
        if (totalCost > bestCost) {
            return new GenerationResult(Status.notEffective, totalCost);
        }

        if (step > 8 * queenRows.length)
            return new GenerationResult(Status.exceedsSteps, totalCost);

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
            if (totalCost < bestCost) bestCost = totalCost;
            return new GenerationResult(Status.done, totalCost);
        }

        List<GenerationResult> results = new ArrayList<GenerationResult>();

        for (Move move : generation) {
            int[] cols = queenCols.clone();
            int[] rows = queenRows.clone();
            cols[move.index] = move.col;
            rows[move.index] = move.row;
            GenerationResult result = calculateGeneration(rows, cols, step + 1, totalCost + move.cost);
            if (result.getStatus() == Status.done) {
                result.step = new MoveStep(move, result.step);
                results.add(result);
            }
        }

        if (results.size() != 0) {
            if (results.size() == 1)
                return new GenerationResult(Status.done, results.get(0).totalCost, results.get(0).step);
            int minCost = results.get(0).totalCost;
            int minIndex = 0;
            for(int i = 1; i < results.size(); i++) {
                if (results.get(i).totalCost < minCost) {
                    minCost = results.get(i).totalCost;
                    minIndex = i;
                }
            }
            return new GenerationResult(Status.done, results.get(minIndex).totalCost, results.get(minIndex).step);
        } else {
            return new GenerationResult(Status.notEffective, totalCost);
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
