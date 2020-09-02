import init.InversionCounter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry on 2/26/2015.
 */
public class InversionCounterTest {

    private long calculateInversions(int [] array) {
        long inv_count = 0;
        int i, j;

        for(i = 0; i < array.length -1; i++)
            for(j = i+1; j < array.length; j++)
                if(array[i] > array[j])
                    inv_count++;
        return inv_count;
    }

    @Test
    public void compute(){
        InversionCounter counter = new InversionCounter();
        int [] array = {2,4,1,6,8,5,3,7};

        long inv = calculateInversions(array);

        long count = counter.inversions(array);


        assertEquals(inv, count);
    }

    @Test
    public void compute2(){
        InversionCounter counter = new InversionCounter();
        int [] array = {1,3,5,2,4,6};
        long inv = calculateInversions(array);
        long count = counter.inversions(array);
        assertEquals(inv, count);
    }

    @Test
    public void compute3(){
        InversionCounter counter = new InversionCounter();
        int [] array = {1,2,3,4,5,6};
        long inv = calculateInversions(array);
        long count = counter.inversions(array);
        assertEquals(inv, count);
    }

    @Test
    public void compute4(){
        InversionCounter counter = new InversionCounter();
        int [] array = {1,3,5,2,4};
        long inv = calculateInversions(array);
        long count = counter.inversions(array);
        assertEquals(inv, count);
    }

    @Test
    public void compute5(){
        InversionCounter counter = new InversionCounter();
        int [] array = {5,4,3,2,1};
        long inv = calculateInversions(array);
        long count = counter.inversions(array);
        assertEquals(inv, count);
    }

    @Test
    public void compute6(){
        InversionCounter counter = new InversionCounter();
        int [] array = {6,5,4,3,2,1};
        long inv = calculateInversions(array);
        long count = counter.inversions(array);
        assertEquals(inv, count);
    }

    @Test
    public void sort(){
        InversionCounter counter = new InversionCounter();
        int [] array = {2,4,1,6,8,5,3,7};
        array = counter.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, array);
    }

    @Test
    public void sort2(){
        InversionCounter counter = new InversionCounter();
        int [] array = {1,3,5,2,4,6};
        array = counter.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, array);
    }
}
