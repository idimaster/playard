import init.TSPDynamic;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry on 5/3/2015.
 */
public class TspTest {

    @Test
    public void loadTSP() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("tsp.dat");
        TSPDynamic t = new TSPDynamic();
        t.load(url);
        assertEquals(18, t.getCount());
    }

    @Test
         public void calculate() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("tsp.dat");
        TSPDynamic t = new TSPDynamic();
        t.load(url);
        double v = t.calculate();
        assertEquals(3.50116, v, 0.01);
    }

    @Test
    public void calculate1() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("tsp1.dat");
        TSPDynamic t = new TSPDynamic();
        t.load(url);
        double v = t.calculate();
        assertEquals(1.64301, v, 0.01);
    }

    @Test
    public void calculate0() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("tsp0.dat");
        TSPDynamic t = new TSPDynamic();
        t.load(url);
        double v = t.calculate();
        assertEquals(10, v, 0.01);
    }


    public void calculateA() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("tspA.dat");
        TSPDynamic t = new TSPDynamic();
        t.load(url);
        double v = t.calculate();
        assertEquals(10, v, 0.01);
    }

    @Test
    public void calculatex() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("tspx.dat");
        TSPDynamic t = new TSPDynamic();
        t.load(url);
        double v = t.calculate();
        assertEquals(3.50116, v, 0.01);
    }

    @Test
    public void calculatey() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("tspy.dat");
        TSPDynamic t = new TSPDynamic();
        t.load(url);
        double v = t.calculate();
        assertEquals(3.50116, v, 0.01);
    }
}
