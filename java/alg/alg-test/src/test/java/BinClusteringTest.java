import init.BinClustering;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dnitry on 4/12/2015.
 */
public class BinClusteringTest {
    @Test
    public void load() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("bit.dat");
        BinClustering c = new BinClustering();
        c.load(url);
        assertEquals(26, c.getNodeCount());
        assertTrue(c.getNodes().contains(14734287));
        assertTrue(c.getNodes().contains(16504102));
        assertTrue(c.getNodes().contains(5849367));
        assertTrue(c.getNodes().contains(15091705));
    }

    @Test
    public void calculate() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("bit.dat");
        BinClustering c = new BinClustering();
        c.load(url);
        c.calculate();
    }
}
