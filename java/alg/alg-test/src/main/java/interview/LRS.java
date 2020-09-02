package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmitry on 4/26/2015.
 */
public class LRS {

    private static final String del1 = "&";
    private static final String del2 = "$";

    //largest repeating substring
    public String selectLRS(String input) {
        if (input == null) throw new IllegalArgumentException("input cannot be null");
        List<String> suffices = new ArrayList<String>();
        for (int i = 0; i < input.length(); i++) {
            suffices.add(input.substring(i));
        }
        Collections.sort(suffices);

        String lrs = "";
        for(int i = 0; i < suffices.size()-1; i++) {
            String pref = lcp(suffices.get(i), suffices.get(i + 1));
            if(pref.length() > lrs.length()) {
               lrs = pref;
            }
        }
        return lrs;
    }

    // return the longest common prefix of s and t
    private static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }

    // return the longest common prefix of s and t
    private static String lcp2(String s, String t) {
        if(s.endsWith(del1) && t.endsWith(del1)) return "";
        if(s.endsWith(del2) && t.endsWith(del2)) return "";
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }

    //largest common substring
    public String selectLCS(String s1, String s2) {
        if (s1 == null) throw new IllegalArgumentException("s1 cannot be null");
        if (s2 == null) throw new IllegalArgumentException("s2 cannot be null");
        List<String> suffices = new ArrayList<String>();
        for (int i = 0; i < s1.length(); i++) {
            suffices.add(s1.substring(i) + del1);
        }
        for (int i = 0; i < s2.length(); i++) {
            suffices.add(s2.substring(i) + del2);
        }
        Collections.sort(suffices);

        String lrs = "";
        for(int i = 0; i < suffices.size()-1; i++) {
            String pref = lcp2(suffices.get(i), suffices.get(i + 1));
            if(pref.length() > lrs.length()) {
                lrs = pref;
            }
        }
        return lrs;
    }

    //larges Palindrome substring
    public String selectLPS(String s) {
        if (s == null) throw new IllegalArgumentException("s cannot be null");
        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char t = chars[i];
            chars[i] = chars[chars.length - i -1];
            chars[chars.length - i -1] = t;
        }
        String reverse = new String(chars);
        return selectLCS(s, reverse);
    }
}
