package interview2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fluff on 7/6/16.
 */
public class DependencyCyclesTest {

    private List<List<List<DependencyCycles.Reference>>>initSheet(int[][][] data) {
        List<List<List<DependencyCycles.Reference>>> list = new ArrayList<List<List<DependencyCycles.Reference>>>();
        for(int j = 0; j < data.length; j++) {
            list.add(new ArrayList<List<DependencyCycles.Reference>>());
            for(int i =0; i < data[j].length; i++) {
                DependencyCycles.Reference ref = null;
            /*    if (data[j][i] != 0) {
                    int row = (data[j][i] / 10) % 10;
                    int col = data[j][i] % 10;
                    ref = new DependencyCycles.Reference(row, col);
                }
                list.get(j).add(ref);*/
            }
        }
        return list;
    }

    @Test
    public void test1() {
        //Lissheet
    }
}
