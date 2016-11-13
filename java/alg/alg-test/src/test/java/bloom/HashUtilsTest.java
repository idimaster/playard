package bloom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fluff on 7/25/16.
 */
public class HashUtilsTest {
    @Test
    public void fnv() {
        int hash = HashUtils.fnv_1("Test string");
        assertTrue(hash != 0);
    }

    @Test
    public void fnv1a() {
        int hash = HashUtils.fnv_1a("Test string");
        assertTrue(hash != 0);
    }

    @Test
    public void murmur() {
        int hash = HashUtils.murmur("Test string", 0);
        assertTrue(hash != 0);
    }

    @Test
    public void hash16() {
        assertEquals(0, HashUtils.hash16(0xffffffff));
        assertEquals(0xffff, HashUtils.hash16(0xffff));
        assertEquals(0xffff, HashUtils.hash16(0xffff0000));
    }
}
