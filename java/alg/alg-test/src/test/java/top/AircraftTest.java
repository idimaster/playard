package top;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry on 6/21/2015.
 */
public class AircraftTest {
    @Test
    public void test0() {
        int[] p1 ={15,50,5};
        int[] v1 ={25,1,0};
        int[] p2 ={161,102,9};
        int[] v2 ={-10,-10,-1};
        assertEquals("YES", new Aircraft().nearMiss(p1, v1, p2, v2, 10));
    }
    @Test
    public void test1() {
        int[] p1 ={0,0,0};
        int[] v1 ={2,2,0};
        int[] p2 ={9,0,5};
        int[] v2 ={-2,2,0};
        assertEquals("YES", new Aircraft().nearMiss(p1, v1, p2, v2, 5));
    }
    @Test
    public void test2() {
        int[] p1 ={0,0,0};
        int[] v1 ={-2,2,0};
        int[] p2 ={9,0,5};
        int[] v2 ={2,2,0};
        assertEquals("NO", new Aircraft().nearMiss(p1, v1, p2, v2, 5));
    }
    @Test
    public void test3() {
        int[] p1 ={-2838,-7940,-2936};
        int[] v1 ={1,1,-2};
        int[] p2 ={532,3850,9590};
        int[] v2 ={1,0,-3};
        assertEquals("YES", new Aircraft().nearMiss(p1, v1, p2, v2, 3410));
    }
    @Test
    public void test4() {
        int[] p1 ={-8509,9560,345};
        int[] v1 ={-89,-33,62};
        int[] p2 ={-5185,-1417,2846};
        int[] v2 ={-58,24,26};
        assertEquals("YES", new Aircraft().nearMiss(p1, v1, p2, v2, 8344));
    }

    @Test
    public void test5() {
        int[] p1 ={-7163,-371,-2459};
        int[] v1 ={-59,-41,-14};
        int[] p2 ={-2398,-426,-5487};
        int[] v2 ={-43,27,67};
        assertEquals("NO", new Aircraft().nearMiss(p1, v1, p2, v2, 5410));
    }
    @Test
    public void test6() {
        int[] p1 ={1774,-4491,7810};
        int[] v1 ={-12,19,-24};
        int[] p2 ={2322,3793,9897};
        int[] v2 ={-12,19,-24};
        assertEquals("YES", new Aircraft().nearMiss(p1, v1, p2, v2, 10000));
    }
    @Test
    public void test7() {
        int[] p1 ={3731,8537,5661};
        int[] v1 ={-70,71,32};
        int[] p2 ={8701,-1886,-5115};
        int[] v2 ={28,-13,7};
        assertEquals("NO", new Aircraft().nearMiss(p1, v1, p2, v2, 9766));
    }
}
