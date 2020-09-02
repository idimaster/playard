package init;
import java.net.URL;


/**
 * Created by Dmitry on 2/26/2015.
 */
public class DefaultMST {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/edges.txt");
            MSTAlg.Graph g = MSTAlg.Graph.load(url);
            MSTAlg alg = new MSTAlg();
            MSTAlg.Tree t = alg.calculate(g);
            System.out.println(t.getCost());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
