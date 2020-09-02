package init;
import java.net.URL;


/**
 * Created by Dmitry on 2/26/2015.
 */
public class DefaultClustering {
    public static void main(String [] args) {
        try {
            URL url = new URL("http://spark-public.s3.amazonaws.com/algo2/datasets/clustering1.txt");
            SingleLinkClustering.Graph g = SingleLinkClustering.Graph.load(url);
            SingleLinkClustering c = new SingleLinkClustering();
            System.out.println(c.clustering(g, 4));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
