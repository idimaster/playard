import static java.lang.Math.abs;

public class ReverseInteger {
    public int reverse(int x) {
        String str = Integer.toString(abs(x));
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if (x < 0) {
            sb.insert(0, "-");
        }
        return Integer.parseInt(sb.toString());
    }

    public int reverse2(int x) {
        int rev = 0;
        while(x > 0) {
            int pop = x %= 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
