package bloom;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by fluff on 7/25/16.
 */
public class BloomFilterTest {
    @Test
    public void test1() {
        BloomFilter filter = new BloomFilter();
        filter.set("Test string");
        filter.set("Test string1");
        filter.set("Test string2");
        filter.set("Test string3");
        assertTrue(filter.get("Test string"));
        assertTrue(filter.get("Test string1"));
        assertTrue(filter.get("Test string2"));
        assertTrue(filter.get("Test string3"));
        assertFalse(filter.get("Test string4"));
    }
}
