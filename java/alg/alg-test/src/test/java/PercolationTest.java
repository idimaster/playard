import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dnitry on 6/26/2015.
 */
public class PercolationTest {

    @Test
    public void testBackwash() {
        Percolation perc = new Percolation(3);
        perc.open(1, 3);
        assertTrue(perc.isFull(1,3));
        perc.open(3, 3);
        perc.open(3, 1);
        assertFalse(perc.isFull(3, 1));
        assertFalse(perc.isFull(3, 3));
        perc.open(2, 3);
        assertTrue(perc.isFull(2,3));
        assertTrue(perc.isFull(3, 3));
        assertFalse(perc.isFull(3, 1));
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput1() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input1.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput1no() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input1-no.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse(perc.percolates());
    }
    @Test
    public void testInput2() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input2.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput2no() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input2-no.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse(perc.percolates());
    }

    @Test
    public void testInput3() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input3.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput4() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input4.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput5() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input5.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput6() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input6.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput7() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input7.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput8() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input8.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput8no() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input8-no.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse(perc.percolates());
    }

    @Test
    public void testInput10() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input10.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput10no() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input10-no.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse(perc.percolates());
    }

    @Test
    public void testInput20() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input20.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testInput50() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/input50.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testWayne98() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/wayne98.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }

    @Test
    public void testSedgewick60() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("alg1/sedgewick60.txt");
        In in = new In(url);      // input file
        int N = in.readInt();         // N-by-N percolation system

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue(perc.percolates());
    }
}
