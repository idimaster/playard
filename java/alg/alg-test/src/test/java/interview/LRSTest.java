package interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dnitry on 4/26/2015.
 */
public class LRSTest {
    @Test
    public void test1(){
        assertEquals("test tes", new LRS().selectLRS("test test tes"));
    }

    @Test
    public void test2(){
        assertEquals("ana", new LRS().selectLRS("banana"));
    }

    @Test
    public void test3(){
        assertEquals("", new LRS().selectLRS("abcde"));
    }

    @Test
    public void selectLCS() {
        assertEquals("de frrs", new LRS().selectLCS("abcde frrs", "abcdsde frrss"));
    }

    @Test
    public void selectLCS2() {
        assertEquals("c", new LRS().selectLCS("abcd", "klmnc"));
    }

    @Test
    public void selectLCS3() {
        assertEquals("", new LRS().selectLCS("abcd", "klmn"));
    }

    @Test
    public void selectLPS() {
        assertEquals("bcdcb", new LRS().selectLPS("abcdcb"));
    }

    @Test
    public void selectLPS2() {
        assertEquals("", new LRS().selectLPS("abcde"));
    }

    @Test
    public void selectLPS3() {
        assertEquals("avid diva", new LRS().selectLPS("avid diva"));
    }
}
