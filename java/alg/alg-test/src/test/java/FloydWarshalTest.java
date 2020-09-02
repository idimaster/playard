import init.FloydWarshal;
import init.SingleLinkClustering;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Dmitry on 4/26/2015.
 */
public class FloydWarshalTest {
    @Test
    public void calculation() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("FloydWarshal.dat");
        FloydWarshal.Graph g = FloydWarshal.Graph.load(url);
        FloydWarshal c = new FloydWarshal();
        assertEquals(-2, c.calculate(g).intValue());
    }

    @Test
    public void calculation2() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("FloydWarshal.dat");
        FloydWarshal.Graph g = FloydWarshal.Graph.load(url);
        FloydWarshal c = new FloydWarshal();
        assertEquals(-2, c.calculate2(g).intValue());
    }

    @Test
    public void fw1() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("fw1.dat");
        FloydWarshal.Graph g = FloydWarshal.Graph.load(url);
        FloydWarshal c = new FloydWarshal();
        assertEquals(-10003, c.calculate(g).intValue());
    }

    @Test
    public void fw2() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("fw2.dat");
        FloydWarshal.Graph g = FloydWarshal.Graph.load(url);
        FloydWarshal c = new FloydWarshal();
        assertEquals(-6, c.calculate(g).intValue());
    }

    @Test
    public void fw3() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("fw3.dat");
        FloydWarshal.Graph g = FloydWarshal.Graph.load(url);
        FloydWarshal c = new FloydWarshal();
        assertNull(c.calculate(g));
    }

}
