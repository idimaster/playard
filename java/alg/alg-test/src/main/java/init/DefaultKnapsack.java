package init;

import java.net.URL;


/**
 * Created by Dnitry on 4/17/2015.
 */
public class DefaultKnapsack {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/knapsack1.txt");
            URL url2 = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/knapsack_big.txt");
            Knapsack k = new Knapsack();
            k.loadData(url);
            long count = k.calculateOptimal();
            System.out.println(count);
            count = k.calculateOptimal2();
            System.out.println(count);

            k.loadData(url2);
            count = k.calculateOptimal2();
            System.out.println(count);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
