import init.SingleLinkClustering;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dnitry on 4/11/2015.
 */
public class SingleLinkClusteringTest {
    @Test
    public void loadGraph() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("clustering.dat");
        SingleLinkClustering.Graph g = SingleLinkClustering.Graph.load(url);
        assertEquals(8, g.getNodeCount());
        assertEquals(16, g.getEdges().size());
    }

    @Test
    public void calculation() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("clustering.dat");
        SingleLinkClustering.Graph g = SingleLinkClustering.Graph.load(url);
        SingleLinkClustering c = new SingleLinkClustering();
        assertEquals(26, c.clustering(g, 4));
        assertEquals(35, c.clustering(g, 2));
    }
}
