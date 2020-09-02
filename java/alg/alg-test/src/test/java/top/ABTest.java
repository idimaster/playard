package top;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry on 6/17/2015.
 */
public class ABTest {

    static public int calcAB(String str) {
        final char[] ch = str.toCharArray();
        assert ch.length >= 2;
        int countB = 0;
        for(int i = 0; i < ch.length; i++) {
            if (ch[i] == 'B') countB++;
        }
        int count = 0;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i]=='B') {
                countB--;
            } else {
                assert ch[i]=='A';
                count += countB;
            }
        }
        return count;
    }

    @Test
    public void selfTest(){
        assertEquals(2, calcAB("ABB"));
        assertEquals(0, calcAB("BA"));
        assertEquals(12, calcAB("BAABBABAAB"));
    }

    @Test
    public void test1() {
        String res = new AB().createString(3, 2);
        assertEquals(3, res.length());
        assertEquals(2, calcAB(res));
    }

    @Test
    public void test2() {
        String res = new AB().createString(4, 2);
        assertEquals(4, res.length());
        assertEquals(2, calcAB(res));
    }

    @Test
    public void test3() {
        String res = new AB().createString(2, 0);
        assertEquals(2, res.length());
        assertEquals(0, calcAB(res));
    }

    @Test
    public void test4() {
        String res = new AB().createString(5, 8);
        assertEquals("", res);
    }

    @Test
    public void test5() {
        String res = new AB().createString(10, 12);
        assertEquals(10, res.length());
        assertEquals(12, calcAB(res));
    }
}
