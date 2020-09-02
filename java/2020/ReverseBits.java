import static java.lang.Math.abs;

public class ReverseBits {
    public int reverse(int x) {
        String str = Integer.toString(abs(x));
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        return Integer.getInteger(sb.reverse().toString());
    }
}
