import java.util.*;

class Brackets {
    private String leftToRight(String s, int[] br) {
        StringBuilder sb = new StringBuilder(s);
        int balance = 0;
        int deleted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='(') {
                if (balance >= br[i]) {
                    sb.deleteCharAt(i-deleted);
                    deleted++;
                } else {
                    balance ++;
                }
            }
            if (s.charAt(i) ==')') {
                if (balance > 0) {
                    balance --;
                } else {
                    sb.deleteCharAt(i-deleted);
                    deleted++;
                }
            }
        }
        return sb.toString();
    }

    private String rightToLeft(String s, int[] bl) {
        StringBuilder sb = new StringBuilder(s);
        int balance = 0;
        for (int i = s.length() - 1 ; i >= 0; i--) {
            if (s.charAt(i) ==')') {
                if (balance >= bl[i]) {
                    sb.deleteCharAt(i);
                } else {
                    balance ++;
                }
            }
            if (s.charAt(i) =='(') {
                if (balance > 0) {
                    balance --;
                } else {
                    sb.deleteCharAt(i);
                }
            }
        }
        return sb.toString();
    }

    public List<String> removeInvalidParentheses(String s) {
        //Clean string
        StringBuilder sb = new StringBuilder(s);
        int deleted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='(') {
                break;
            }
            if (s.charAt(i) ==')') {
                sb.deleteCharAt(i - deleted);
                deleted++;
            }
        }
        String ss = sb.toString();
        for (int i = ss.length() - 1 ; i >= 0; i--) {
            if (ss.charAt(i) ==')') {
                break;
            }
            if (ss.charAt(i) =='(') {
                sb.deleteCharAt(i);
            }
        }
        s = sb.toString();
        int[] bl = new int[s.length()];
        int[] br = new int[s.length()];
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='(') {
                balance ++;
            }
            bl[i] = balance;
        }
        balance = 0;
        for (int i = s.length() - 1 ; i >= 0; i--) {
            if (s.charAt(i) ==')') {
                balance ++;
            }
            br[i] = balance;
        }
        List<String> result = new ArrayList<>();
        if ("".equals(s)) {
            result.add("");
            return result;
        }
        String s1 = leftToRight(s, br);
        result.add(s1);
        if (!"".equals(s1)) {
            String s2 = rightToLeft(s, bl);
            if (!s1.equals(s2)) {
                result.add(s2);
            }
        }
        return result;
    }
}