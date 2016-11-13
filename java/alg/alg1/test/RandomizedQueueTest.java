import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

public class RandomizedQueueTest {

    @Test
    public void test() {
        List<String> list = Arrays.asList(new String[]{"A", "B", "C", "D", "E", "F", "G", "H"});
        Set<String> hash = new HashSet<String>(list);
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        for (String s : list) {
            q.enqueue(s);
        }
        assertEquals(8, q.size());
        for (String s : q) {
            assertTrue(hash.contains(s));
        }
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList(new String[]{"A", "B", "C", "D", "E", "F", "G", "H"});
        Set<String> hash = new HashSet<String>(list);
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        for (String s : list) {
            q.enqueue(s);
        }
        assertEquals(8, q.size());
        int size = q.size();
        for (int i = 0; i < q.size(); i++) {
            String s = q.dequeue();
            assertTrue(hash.contains(s));
        }
    }


    @Test
    public void test2() {
        List<String> list = Arrays.asList(new String[]{"A", "B", "C", "D", "E", "F", "G", "H"});
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        Set<String> hash = new HashSet<String>(list);
        for (String s : list) {
            q.enqueue(s);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(hash.contains(q.sample()));
        }
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList(new String[]{"A", "B", "C", "D", "E", "F", "G", "H"});
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        Set<String> hash = new HashSet<String>(list);
        for (String s : list) {
            q.enqueue(s);
        }
        q.dequeue();
        q.dequeue();
        for (int i = 0; i < 10; i++) {
            assertTrue(hash.contains(q.sample()));
        }
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        for (int i = 0; i < 10; i++) {
            assertTrue(hash.contains(q.sample()));
        }
        q.dequeue();
        for (int i = 0; i < 10; i++) {
            assertTrue(hash.contains(q.sample()));
        }
        q.enqueue("F");
        for (int i = 0; i < 10; i++) {
            assertTrue(hash.contains(q.sample()));
        }
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList(new String[]{"A", "B", "C", "D", "E"});
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        Map<String, Integer> hash = new HashMap<String, Integer>();
        for (String s : list) {
            hash.put(s, 0);
        }
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        for (int i = 0; i < 3000; i++) {
            String s = q.sample();
            hash.put(s, hash.get(s) + 1);
        }
        assertEquals(1000, hash.get("A").intValue());
        assertEquals(1000, hash.get("B").intValue());
        assertEquals(1000, hash.get("C").intValue());
        for (String s : list) {
            hash.put(s, 0);
        }
        q.enqueue("D");
        q.enqueue("E");
        for (int i = 0; i < 5000; i++) {
            String s = q.sample();
            hash.put(s, hash.get(s) + 1);
        }
        assertEquals(1000, hash.get("A").intValue());
        assertEquals(1000, hash.get("B").intValue());
        assertEquals(1000, hash.get("C").intValue());
        assertEquals(1000, hash.get("D").intValue());
        assertEquals(1000, hash.get("E").intValue());
    }

    @Test
    public void test5() {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        q.enqueue("A");
        Iterator<String> i = q.iterator();
        assertTrue(i.hasNext());
        assertEquals("A", i.next());
        assertFalse(i.hasNext());
        q.enqueue("B");
        i = q.iterator();
        assertTrue(i.hasNext());
        assertEquals("A", i.next());
        assertTrue(i.hasNext());
        assertEquals("B", i.next());
        assertFalse(i.hasNext());
    }
}
