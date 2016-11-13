package bloom;

/**
 * Created by Dmitry on 7/25/16.
 */
public class BitSet {
    private final byte data[];
    private final int size;

    public BitSet(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size cannot be less or equal to zero");
        this.size = size;
        int length = size >> 3;
        if ((size & 7) > 0) {
            length ++;
        }
        data = new byte[length];
    }

    public int getSize() {
        return size;
    }

    private void validateIndex(int index) {
        if (index < 0) throw new IllegalArgumentException("Index cannot be less then zero");
        if (index >= size) throw new IndexOutOfBoundsException("Index cannot exceed of set size");
    }

    public void set(int index) {
        validateIndex(index);
        int idx = index >> 3;
        byte bit = (byte)(index & 7);
        byte mask = (byte)(1 << bit);
        data[idx] |= mask;
    }

    public void clear(int index) {
        validateIndex(index);
        int idx = index >> 3;
        byte bit = (byte)(index & 7);
        byte mask = (byte)~(1 << bit);
        data[idx] &= mask;
    }

    public boolean get(int index) {
        validateIndex(index);
        int idx = index >> 3;
        byte bit = (byte)(index & 7);
        byte mask = (byte)(1 << bit);
        return (data[idx] & mask) != 0;
    }
}
