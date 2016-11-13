import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class ListItem {
        private ListItem next;
        private ListItem prev;
        private Item item;
    }

    private class IteratorImpl implements Iterator<Item> {

        private ListItem pos;

        public IteratorImpl(ListItem pos) {
            this.pos = pos;
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
            return pos != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if (pos == null) throw new NoSuchElementException();
            Item res = pos.item;
            pos = pos.next;
            return res;
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

    private ListItem head;
    private ListItem tail;
    private int size;

    public Deque() {                          // construct an empty deque
        size = 0;
    }

    public boolean isEmpty() {                // is the deque empty?
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        if (head == null) {
            head = new ListItem();
            tail = head;
        } else {
            ListItem newHead = new ListItem();
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
        head.item = item;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        if (head == null) {
            head = new ListItem();
            tail = head;
        } else {
            ListItem newTail = new ListItem();
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        }
        tail.item = item;
        size++;
    }

    public Item removeFirst() {
        if (head == null) throw new NoSuchElementException();
        Item result = head.item;
        ListItem next = head.next;
        head.item = null;
        head.next = null;
        head = next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return result;
    }

    public Item removeLast() {
        if (head == null) throw new NoSuchElementException();
        Item result = tail.item;
        ListItem prev = tail.prev;
        tail.item = null;
        tail.prev = null;
        tail = prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return result;
    }

    public Iterator<Item> iterator() {
        return new IteratorImpl(head);
    }
}
