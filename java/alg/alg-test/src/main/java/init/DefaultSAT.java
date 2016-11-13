package init;

import java.net.URL;

/**
 * Created by Dnitry on 5/10/2015.
 */
public class DefaultSAT {
    public static void main(String [] args) {
        try {
            URL url = new URL("https://spark-public.s3.amazonaws.com/algo2/datasets/2sat1.txt");
            TwoSAT2 sat = new TwoSAT2();
            sat.load(url);
            boolean s = sat.calcSatisfiability();
            System.out.println(s);
            url = new URL("https://spark-public.s3.amazonaws.com/algo2/datasets/2sat2.txt");
            sat = new TwoSAT2();
            sat.load(url);
            s = sat.calcSatisfiability();
            System.out.println(s);
            url = new URL("https://spark-public.s3.amazonaws.com/algo2/datasets/2sat3.txt");
            sat = new TwoSAT2();
            sat.load(url);
            s = sat.calcSatisfiability();
            System.out.println(s);
            url = new URL("https://spark-public.s3.amazonaws.com/algo2/datasets/2sat4.txt");
            sat = new TwoSAT2();
            sat.load(url);
            s = sat.calcSatisfiability();
            System.out.println(s);
            url = new URL("https://spark-public.s3.amazonaws.com/algo2/datasets/2sat5.txt");
            sat = new TwoSAT2();
            sat.load(url);
            s = sat.calcSatisfiability();
            System.out.println(s);
            url = new URL("https://spark-public.s3.amazonaws.com/algo2/datasets/2sat6.txt");
            sat = new TwoSAT2();
            sat.load(url);
            s = sat.calcSatisfiability();
            System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
