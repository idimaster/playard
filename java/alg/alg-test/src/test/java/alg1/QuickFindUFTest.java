package alg1;

import org.junit.Test;

/**
 * Created by Dnitry on 6/20/2015.
 */
public class QuickFindUFTest {
    @Test
    public void calculate() {
        QuickFindUF uf = new QuickFindUF(10);
        //9-4 8-6 3-0 0-1 7-8 4-6
        //1-8 0-7 1-4 7-3 4-9 7-2
        uf.union(1,8);
        uf.union(0,7);
        uf.union(1,4);
        uf.union(7,3);
        uf.union(4,9);
        uf.union(7,2);
        uf.connected(4,5);
    }
}
