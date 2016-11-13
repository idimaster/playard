import init.TwoSAT;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dnitry on 5/10/2015.
 */
public class TwoSATTest {

    @Test
    public void loadSAT() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("SAT.dat");
        TwoSAT sat = new TwoSAT();
        sat.load(url);
        assertEquals(7,sat.getCount());
    }

    @Test
    public void calculate() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("SAT.dat");
        TwoSAT sat = new TwoSAT();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate1() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat1.dat");
        TwoSAT sat = new TwoSAT();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate2() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat2.dat");
        TwoSAT sat = new TwoSAT();
        sat.load(url);
        assertFalse(sat.calcSatisfiability());
    }

    @Test
    public void calculate3() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat3.dat");
        TwoSAT sat = new TwoSAT();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }
}
