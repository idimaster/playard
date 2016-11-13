package init;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Dnitry on 2/26/2015.
 */
public class DefaultJobs {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/jobs.txt");
            Scanner s = new Scanner(url.openStream());

            int i = 0;
            JobScheduler.JobDefinition [] array = null;
            try {
                int size = s.nextInt();
                array = new JobScheduler.JobDefinition[size];
                while (true) {
                    int weight = s.nextInt();
                    int length = s.nextInt();
                    array[i] = new JobScheduler.JobDefinition(weight, length);
                    i++;
                }
            } catch(NoSuchElementException e) {}
            System.out.println(i);
            JobScheduler sh = new JobScheduler(new JobScheduler.JobSchedulerStrategy1());
            sh.schedule(array);
            long sum = sh.calculateWeightedCompletionTime(array);
            System.out.println(sum);
            sh = new JobScheduler(new JobScheduler.JobSchedulerStrategy2());
            sh.schedule(array);
            sum = sh.calculateWeightedCompletionTime(array);
            System.out.println(sum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
