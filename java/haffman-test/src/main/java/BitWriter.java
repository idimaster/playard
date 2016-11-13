import java.io.ByteArrayOutputStream;

/**
 * Created by fluff on 7/28/16.
 */
public class BitWriter {
    private int data = 0;
    int size = 0;
    int index = 0;

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void add(boolean value) {
        if (value) {
            byte bit = (byte) (index & 7);
            byte mask = (byte) (1 << bit);
            data |= mask;
        }
        index++;
        if(index > 7) {
            out.write(data);
            data = 0;
            index = 0;
        }
    }

    public BitSet getBitSet() {
        return new BitSet(size, out.toByteArray());
    }

    public byte[] getData() {
        return out.toByteArray();
    }
}
