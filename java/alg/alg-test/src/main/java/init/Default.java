package init;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Dmitry on 2/26/2015.
 */
public class Default {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo1/programming_prob/IntegerArray.txt");
            Scanner s = new Scanner(url.openStream());
            int i = 0;
            int [] array = new int[100000];
            try {
                while (true) {
                    array[i] = s.nextInt();
                    i++;
                }
            } catch(NoSuchElementException e) {}
            System.out.println(i);
            InversionCounter counter = new InversionCounter();
            long count = counter.inversions(array);
            System.out.println(count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
