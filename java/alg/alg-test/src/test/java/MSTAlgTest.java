import init.MSTAlg;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry on 3/29/2015.
 */
public class MSTAlgTest {

    @Test
    public void loadGraph() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("graph.dat");
        MSTAlg.Graph g = MSTAlg.Graph.load(url);
        assertEquals(8, g.getNodeCount());
        assertEquals(16, g.getEdges().length);
    }

    @Test
    public void calculation() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("graph.dat");
        MSTAlg.Graph g = MSTAlg.Graph.load(url);
        MSTAlg alg = new MSTAlg();
        MSTAlg.Tree t = alg.calculate(g);
        assertEquals(181, t.getCost());
    }
}
