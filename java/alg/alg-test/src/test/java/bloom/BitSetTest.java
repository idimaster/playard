package bloom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by fluff on 7/25/16.
 */
public class BitSetTest {
    @Test
    public void init() {
        BitSet set = new BitSet(20);
        assertEquals(20, set.getSize());
        set = new BitSet(675);
        assertEquals(675, set.getSize());
    }

    @Test
    public void set_get() {
        BitSet set = new BitSet(45);
        set.set(2);
        assertTrue(set.get(2));
        set.set(16);
        assertTrue(set.get(16));
        set.set(0);
        assertTrue(set.get(0));
        set.set(44);
        assertTrue(set.get(44));
        set.set(33);
        assertTrue(set.get(33));
    }

    @Test
    public void set_get2() {
        BitSet set = new BitSet(45);
        for(int i = 0; i < 45; i++) {
            assertFalse(set.get(i));
        }
        for(int i = 0; i < 45; i++) {
            set.set(i);
        }
        for(int i = 0; i < 45; i++) {
            assertTrue(set.get(i));
        }
    }

    @Test
    public void set_clear() {
        BitSet set = new BitSet(45);
        for(int i = 0; i < 45; i++) {
            assertFalse(set.get(i));
        }
        for(int i = 0; i < 45; i++) {
            set.set(i);
        }
        set.clear(15);
        set.clear(0);
        set.clear(44);
        set.clear(2);
        for(int i = 0; i < 45; i++) {
            if (i == 15 || i == 0 || i ==44 || i == 2) {
                assertFalse(set.get(i));
            }
            else {
                assertTrue(set.get(i));
            }
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void error_init() {
        BitSet set = new BitSet(-3);
    }

    @Test(expected=IllegalArgumentException.class)
    public void error_init2() {
        BitSet set = new BitSet(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void error_get() {
        BitSet set = new BitSet(45);
        set.get(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void error_get2() {
        BitSet set = new BitSet(45);
        set.get(46);
    }

    @Test(expected=IllegalArgumentException.class)
    public void error_set() {
        BitSet set = new BitSet(45);
        set.set(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void error_set2() {
        BitSet set = new BitSet(45);
        set.set(46);
    }

    @Test(expected=IllegalArgumentException.class)
    public void error_clear() {
        BitSet set = new BitSet(45);
        set.clear(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void error_clear2() {
        BitSet set = new BitSet(45);
        set.clear(46);
    }
}
