package init;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Dmitry on 2/26/2015.
 */
public class InversionCounter {

    static private class InversionCount {
        final long count;
        final int[] array;

        public InversionCount(long count, int[] array) {
            this.count = count;
            this.array = array;
        }
    }

    static private class InversionCounterTask extends RecursiveTask<InversionCount> {

        private final int[] array;
        long count = 0;

        public InversionCounterTask(int[] array) {
            this.array = array;
        }

        @Override
        protected InversionCount compute() {
            if (array.length <= 1)  return new InversionCount(0, array);
            if (array.length == 2) {
                if (array[0] > array[1]) {
                    count ++;
                    int t = array[0];
                    array[0] = array[1];
                    array[1] = t;
                }
                return new InversionCount(count, array);
            }
            int newSize = array.length / 2;
            int[] left = new int[newSize];
            int[] right = new int[array.length - newSize];
            System.arraycopy(array, 0, left, 0, newSize);
            System.arraycopy(array, newSize, right, 0, array.length - newSize);
            final InversionCounterTask leftTask = new InversionCounterTask(left);
            final InversionCounterTask rightTask = new InversionCounterTask(right);
            ForkJoinTask<InversionCount> leftResTask = leftTask.fork();
            ForkJoinTask<InversionCount> rightResTask  = rightTask.fork();
            InversionCount leftRes = leftResTask.join();
            InversionCount rightRes = rightResTask.join();
            return merge(leftRes, rightRes);
        }

        private InversionCount merge(InversionCount leftRes, InversionCount rightRes) {
            int splits = 0;
            int i = 0;
            int j = 0;
            for (int k = 0; k < array.length; k++) {
                if (i >= leftRes.array.length) {
                    array[k] = rightRes.array[j];
                    j++;
                } else if (j >= rightRes.array.length) {
                    array[k] = leftRes.array[i];
                    i++;
                } else if (leftRes.array[i] > rightRes.array[j]) {
                    array[k] = rightRes.array[j];
                    j++;
                    splits+=(leftRes.array.length - i);
                } else {
                    array[k] = leftRes.array[i];
                    i++;
                }
            }
            return new InversionCount(leftRes.count + rightRes.count + splits, array);
        }
    }

    public long inversions(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        InversionCount count = pool.invoke(new InversionCounterTask(array));
        return count.count;
    }

    public int[] sort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        InversionCount count = pool.invoke(new InversionCounterTask(array));
        return count.array;
    }
}
