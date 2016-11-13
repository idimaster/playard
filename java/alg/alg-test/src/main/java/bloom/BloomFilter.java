package bloom;

/**
 * Created by fluff on 7/25/16.
 */
public class BloomFilter {
    private final BitSet bitSet;

    public BloomFilter() {
        bitSet = new BitSet(65536);
    }

    public void set(String str) {
        bitSet.set(HashUtils.hash16(HashUtils.fnv_1(str)));
        bitSet.set(HashUtils.hash16(HashUtils.fnv_1a(str)));
        bitSet.set(HashUtils.hash16(HashUtils.murmur(str, 0)));
    }

    public boolean get(String str) {
        int h1 = HashUtils.hash16(HashUtils.fnv_1(str));
        int h2 = HashUtils.hash16(HashUtils.fnv_1a(str));
        int h3 = HashUtils.hash16(HashUtils.murmur(str, 0));
        return bitSet.get(h1) && bitSet.get(h2) && bitSet.get(h3);
    }
}
