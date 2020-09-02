import org.junit.Test;

/**
 * Created by Dmitry on 6/20/2015.
 */
public class WeightedQuickUnionUFTest {
    @Test
    public void calculate(){
        WeightedQuickUnionUF uf=new WeightedQuickUnionUF(10);
        //5-9 4-3 1-9 5-2 0-6 6-4 5-8 5-6 4-7
        // 2-3 2-6 5-7 4-2 0-8 3-9 5-0 1-2 4-0
        uf.union(2,3);
        uf.union(2,6);
        uf.union(5,7);
        uf.union(4,2);
        uf.union(0,8);
        uf.union(3,9);
        uf.union(5,0);
        uf.union(1,2);
        uf.union(4,0);
        uf.connected(4,7);
    }
}
