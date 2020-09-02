package interview;

import java.util.Arrays;

/**
 * Created by Dmitry on 4/26/2015.
 */
public class MaxIncSeq {

    int [] calculate(int [] input) {
        int pos = 0;
        int len = 1;
        int cPos = 0;
        int cLen = 1;
        for (int i = 1; i < input.length; i++) {
           if (input[i-1] < input[i]) {
               cLen ++;
           } else {
               if (cLen > len) {
                   pos = cPos;
                   len = cLen;
               }
               cPos = i;
               cLen = 1;
           }
        }
        if(cLen > len) {
            pos = cPos;
            len = cLen;
        }
        if (len < 2) return null;
        return Arrays.copyOfRange(input, pos, pos + len);
    }
}
