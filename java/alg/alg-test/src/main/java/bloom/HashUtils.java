package bloom;

/**
 * Created by fluff on 7/25/16.
 */
public class HashUtils {
    /*
    see http://isthe.com/chongo/tech/comp/fnv/
     */
    public static int fnv_1(String str) {
        if (str == null) throw new IllegalArgumentException("str cannot be null");
        int hash = 0x811C9DC5;
        for(byte b : str.getBytes()) {
            hash *= 16777619;
            hash ^= b;
        }
        return hash;
    }

    public static int fnv_1a(String str) {
        if (str == null) throw new IllegalArgumentException("str cannot be null");
        int hash = 0x811C9DC5;
        for(byte b : str.getBytes()) {
            hash ^= b;
            hash *= 16777619;
        }
        return hash;
    }

    public static int murmur(String str, int seed) {
        if (str == null) throw new IllegalArgumentException("str cannot be null");
        final int m = 0xc6a4a793;
        final int r = 16;
        int hash = seed ^ (str.length() * m);
        byte b[] = str.getBytes();
        int len = b.length;
        int i = 0;
        while(len >= 4) {
            int l = b[i] + b[i + 1] << 8 + b[i + 2] << 16 + b[i + 3] << 24;
            hash += l;
            hash *= m;
            hash ^= hash >>> r;
            len -=4;
            i += 4;
        }
        switch (len) {
            case 3:
                hash += b[i + 2] << 16;
            case 2:
                hash += b[i + 1] << 8;
            case 1:
                hash += b[i];
                hash *= m;
                hash ^= hash >>> r;
        }
        hash *= m;
        hash ^= hash >>> 10;
        hash *= m;
        hash ^= hash >>> 17;
        return hash;
    }

    public static int hash16(int hash) {
        return hash & 0xffff ^ hash >>> 16;
    }
}
