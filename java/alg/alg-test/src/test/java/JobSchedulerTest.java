import init.JobScheduler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry on 3/29/2015.
 */
public class JobSchedulerTest {

    JobScheduler.JobDefinition [] createJobs() {
        int weight[]={3,2,5,6,7,8,9,3,3,1,3,1,1,4,5};
        int length[]={1,4,1,4,3,4,6,2,8,5,2,5,1,5,2};
        JobScheduler.JobDefinition [] array = new JobScheduler.JobDefinition[length.length];
        for(int i = 0; i<length.length;i++){
            array[i] = new JobScheduler.JobDefinition(weight[i], length[i]);
        }
        return array;
    }

    @Test
    public void computeStrategy1(){
        JobScheduler s = new JobScheduler(new JobScheduler.JobSchedulerStrategy1());
        JobScheduler.JobDefinition [] array = createJobs();
        s.schedule(array);
        long sum = s.calculateWeightedCompletionTime(array);
        assertEquals(1118, sum);
    }

    @Test
    public void computeStrategy2(){
        JobScheduler s = new JobScheduler(new JobScheduler.JobSchedulerStrategy2());
        JobScheduler.JobDefinition [] array = createJobs();
        s.schedule(array);
        long sum = s.calculateWeightedCompletionTime(array);
        assertEquals(1041, sum);
    }
}
