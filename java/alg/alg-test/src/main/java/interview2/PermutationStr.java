package interview2;

import java.util.*;

/**
 * Created by fluff on 7/7/16.
 */
public class PermutationStr {
    private final String str;

    public PermutationStr(String str) {
        if (str == null) {
            throw new IllegalArgumentException("str cannot be null");
        }
        this.str = str;
    }

    private int findChar(char ch, String str, Set exclude) {
        int res = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch && !exclude.contains(i)) {
                return i;
            }
        }
        return res;
    }

    public Date businessDaysFromNow(int n) {
        Calendar cal =  Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
       // Calendar.SUNDAY;
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return cal.getTime();
    }


    public List<Integer> search(String b) {
        if (b == null) {
            throw new IllegalArgumentException("b cannot be null");
        }
        char [] chars = str.toCharArray();
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> exclude = new HashSet<Integer>();
        int pos = 0;
        for(int i = 0; i < chars.length; i++) {
            boolean present = false;
            for(int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == chars[i]) {
                    present = true;
                    chars[i + j] = 0;
                    break;
                }
            }
        }
        return result;
    }
}
