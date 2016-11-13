import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DequeTest {
    @Test
    public void test() {
        Deque<String> d = new Deque<String>();
        d.addFirst("A");
        d.addFirst("B");
        d.addFirst("D");
        assertEquals(3, d.size());
        assertEquals("D", d.removeFirst());
        assertEquals("A", d.removeLast());
        d.addLast("C");
        d.addFirst("E");
        assertEquals("E", d.removeFirst());
        assertEquals("C", d.removeLast());
        d.addLast("F");
        d.addFirst("G");
        assertEquals(3, d.size());
        assertEquals("G", d.removeFirst());
        assertEquals("B", d.removeFirst());
        assertEquals("F", d.removeFirst());
        assertEquals(0, d.size());
        d.addFirst("A");
        d.addFirst("B");
        assertEquals(2, d.size());
        assertEquals("A", d.removeLast());
        assertEquals("B", d.removeLast());
        assertEquals(0, d.size());
    }

    @Test
    public void test1() {
        String[] strings = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        Deque<String> d = new Deque<String>();
        for (String s : strings) {
            d.addFirst(s);
            d.addLast(s);
        }
        int i = strings.length - 1;
        int dx = -1;
        for (String s : d) {
            assertEquals(strings[i], s);
            i += dx;
            if (i < 0) {
                i = 0;
                dx = 1;
            }
        }
    }
}
