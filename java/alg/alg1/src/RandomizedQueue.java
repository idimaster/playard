import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    private class IteratorImpl implements Iterator<Item> {

        private int index;
        private Node pos;

        public IteratorImpl(Node p) {
            pos = p;
            if (pos != null) {
                int i = (int) Math.floor(Math.random() * size);
                for (int k = 0; k < i; k++) {
                    pos = pos.next;
                }
                index = 0;
            }
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return pos != null && index < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if (pos == null || index >= size) throw new NoSuchElementException();
            Item item = pos.item;
            pos = pos.next;
            index++;
            return item;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int size;
    private Node head;

    public RandomizedQueue() {
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (head == null) {
            head = new Node();
            head.item = item;
            head.next = head;
            head.prev = head;
        } else {
            if (Math.random() > 0.5) {
                Node next = head.next;
                head.next = new Node();
                head.next.item = item;
                head.next.next = next;
                head.next.prev = head;
                next.prev = head.next;
            } else {
                Node prev = head.prev;
                head.prev = new Node();
                head.prev.item = item;
                head.prev.prev = prev;
                head.prev.next = head;
                prev.next = head.prev;
            }
        }
        size++;
    }

    public Item dequeue() {
        if (head == null) throw new NoSuchElementException();
        Item result = head.item;
        if (size <= 1) {
            head.item = null;
            head.next = null;
            head.prev = null;
            head = null;
        } else {
            Node next = head.next;
            head.prev.next = next;
            head.next.prev = head.prev;
            head.prev = null;
            head.next = null;
            head.item = null;
            head = next;
        }
        size--;
        return result;
    }

    // return (but do not remove) a head item
    public Item sample() {
        if (head == null) throw new NoSuchElementException();
        Item result = head.item;
        head = head.next;
        return result;
    }

    public Iterator<Item> iterator() {
        return new IteratorImpl(head);
    }
}
