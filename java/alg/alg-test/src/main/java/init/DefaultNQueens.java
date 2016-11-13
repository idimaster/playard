package init;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Dmitry on 2/27/2015.
 */
public class DefaultNQueens {
    public static void main(String [] args) {
        int[] rows = {3, 0, 1, 0, 1, 4, 0, 2};
        int[] cols = {0 ,1, 1, 3, 2, 2, 4, 3};
   /*     Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        rows = new int[size];
        cols = new int[size];
        for(int i = 0; i < size; i++) {
            rows[i] = in.nextInt();
        }
        in.nextInt();
        for(int i = 0; i < size; i++) {
            cols[i] = in.nextInt();
        }     */

        Date time  = Calendar.getInstance().getTime();
        String [] res = new MovingNQueens().rearrange(rows,cols);
        Date time1  = Calendar.getInstance().getTime();
        System.out.println((time1.getTime()-time.getTime()));
        System.out.println(res.length);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.flush();
    }
}
