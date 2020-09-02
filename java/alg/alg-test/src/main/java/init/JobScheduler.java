package init;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Dmitry on 3/28/2015.
 */
public class JobScheduler {
    public static class JobDefinition {
        private final int weight;
        private final int length;

        public JobDefinition(int weight, int length){
            this.weight = weight;
            this.length = length;
        }
    }

    public static class JobSchedulerStrategy1 implements Comparator<JobDefinition> {
        @Override
        public int compare(JobDefinition o1, JobDefinition o2) {
            int w1 = o1.weight - o1.length;
            int w2 = o2.weight - o2.length;
            if(w1 > w2) return -1;
            if(w1 < w2) return 1;
            if(o1.weight > o2.weight) return -1;
            if(o1.weight < o2.weight) return 1;
            return 0;
        }
    }

    public static class JobSchedulerStrategy2 implements Comparator<JobDefinition> {
        @Override
        public int compare(JobDefinition o1, JobDefinition o2) {
            double w1 = (double)o1.weight/o1.length;
            double w2 = (double)o2.weight/o2.length;
            if(w1 > w2) return -1;
            if(w1 < w2) return 1;
            return 0;
        }
    }


    private final Comparator<JobDefinition> comparator;

    public JobScheduler(Comparator<JobDefinition> comparator) {
        this.comparator = comparator;
    }

    public void schedule(JobDefinition[] jobs) {
        Arrays.sort(jobs, comparator);
    }

    public long calculateWeightedCompletionTime(JobDefinition[] jobs) {
        long c = 0;
        long sum = 0;
        for (int i = 0; i< jobs.length; i++){
            c += jobs[i].length;
            sum = sum + c*jobs[i].weight;
        }
        return sum;
    }
}
