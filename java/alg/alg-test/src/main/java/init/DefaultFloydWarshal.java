package init;

import java.net.URL;

/**
 * Created by Dmitry on 4/26/2015.
 */
public class DefaultFloydWarshal {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/g1.txt");
            FloydWarshal.Graph g = FloydWarshal.Graph.load(url);
            FloydWarshal c = new FloydWarshal();
            System.out.println(c.calculate(g));
            System.out.println(c.calculate2(g));
            url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/g2.txt");
            g = FloydWarshal.Graph.load(url);
            System.out.println(c.calculate(g));
            System.out.println(c.calculate2(g));
            url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/g3.txt");
            g = FloydWarshal.Graph.load(url);
            System.out.println(c.calculate(g));
            System.out.println(c.calculate2(g));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
