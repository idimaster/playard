package interview;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dmitry on 4/26/2015.
 */
public class MaxIntSeqTest {

    @Test
    public void test1(){
        int [] input = {4,5,65,6,6,6};
        int [] res = new MaxIncSeq().calculate(input);
        assertNotNull(res);
        assertEquals(3, res.length);
        assertArrayEquals(new int[]{4,5,65}, res);
    }

    @Test
    public void test2(){
        int [] input = {6,5,5,4,3,1};
        int [] res = new MaxIncSeq().calculate(input);
        assertNull(res);
    }

    @Test
    public void test3(){
        int [] input = {6,5,5,3,4,1,2,3,4};
        int [] res = new MaxIncSeq().calculate(input);
        assertEquals(4, res.length);
        assertArrayEquals(new int[]{1,2,3,4}, res);
    }

    @Test
    public void test4(){
        int [] input = {1,2,3,1,2,3,4,0,1,2};
        int [] res = new MaxIncSeq().calculate(input);
        assertEquals(4, res.length);
        assertArrayEquals(new int[]{1, 2, 3, 4}, res);
    }
}
