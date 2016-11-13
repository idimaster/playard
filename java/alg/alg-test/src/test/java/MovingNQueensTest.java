import init.MovingNQueens;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dnitry on 2/28/2015.
 */
public class MovingNQueensTest {

    final int MIN_NQ = 8, MAX_NQ = 100;
    // ----------------------------------------------------------------------------------
    int NQ;                            // number of queens
    int[] QR, QC;                      // coordinates of queens (initial -> current -> final)

    void generate(String seed) {
        try {
            SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
            rnd.setSeed(Long.parseLong(seed));
            if (seed.equals("1")) {
                NQ = MIN_NQ;
            } else {
                NQ = rnd.nextInt(MAX_NQ - MIN_NQ + 1) + MIN_NQ;
            }

            // queens are placed randomly within a SZ x SZ square
            int min_sz = (int) Math.sqrt(NQ) + 1;
            int max_sz = min_sz * 2;
            int sz = rnd.nextInt(max_sz - min_sz + 1) + min_sz;

            QR = new int[NQ];
            QC = new int[NQ];
            char[][] queenPlaced = new char[sz][sz];
            for (int i = 0; i < sz; ++i) {
                Arrays.fill(queenPlaced[i], '.');
            }

            int r, c, nPlaced = 0;
            while (nPlaced < NQ) {
                r = rnd.nextInt(sz);
                c = rnd.nextInt(sz);
                if (queenPlaced[r][c] == '.') {
                    queenPlaced[r][c] = 'Q';
                    QR[nPlaced] = r;
                    QC[nPlaced] = c;
                    ++nPlaced;
                }
            }
        }
        catch (Exception e) {
            System.err.println("An exception occurred while generating the test case.");
            e.printStackTrace();
        }
    }

    @Test
    public void seed_1_8() {
        generate("1");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        assertEquals(4, res.length);
    }

    @Test
    public void seed_2_41() {
        generate("2");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_3_18() {
        generate("3");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_4_89() {
        generate("4");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_5_10() {
        generate("5");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_6_56() {
        generate("6");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_7_11() {
        generate("7");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_8_60() {
        generate("8");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_9_87() {
        generate("9");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }

    @Test
    public void seed_10_33() {
        generate("10");
        String [] res = new MovingNQueens().rearrange(QR, QC);
        //assertEquals(4, res.length);
    }
}
