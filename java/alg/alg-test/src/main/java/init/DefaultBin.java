package init;

import java.net.URL;

/**
 * Created by Dmitry on 4/12/2015.
 */
public class DefaultBin {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/clustering_big.txt");
            BinClustering c = new BinClustering();
            c.load(url);
            System.out.println(c.calculate());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
