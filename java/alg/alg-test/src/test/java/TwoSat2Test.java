import init.TwoSAT2;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dnitry on 5/10/2015.
 */
public class TwoSat2Test {
    @Test
    public void loadSAT() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("SAT.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertEquals(7, sat.getVertCount());
        assertEquals(11, sat.getCount());
    }

    @Test
    public void calculate() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("SAT.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate1() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat1.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate2() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat2.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertFalse(sat.calcSatisfiability());
    }

    @Test
    public void calculate3() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat3.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate4() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat4.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate5() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat5.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertFalse(sat.calcSatisfiability());
    }

    @Test
    public void calculate6() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat6.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate7() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat7.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }

    @Test
    public void calculate8() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("sat8.dat");
        TwoSAT2 sat = new TwoSAT2();
        sat.load(url);
        assertTrue(sat.calcSatisfiability());
    }
}
