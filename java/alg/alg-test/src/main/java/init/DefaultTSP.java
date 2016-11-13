package init;

import java.net.URL;

/**
 * Created by Dnitry on 5/3/2015.
 */
public class DefaultTSP {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/tsp.txt");
            TSPDynamic t = new TSPDynamic();
            t.load(url);
            double v = t.calculate();
            System.out.println(v);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
