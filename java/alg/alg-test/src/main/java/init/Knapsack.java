package init;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Dnitry on 4/17/2015.
 */
public class Knapsack {
    private static class Vertex implements Comparable {
        int value;
        int weight;

        public Vertex(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Vertex v = (Vertex)o;
            return Integer.compare(weight, v.weight);
        }
    }

    int [] w;
    int [] v;
    int knapsack_size;
    int size;

    public void loadData(URL url) throws IOException{
        Scanner s = new Scanner(url.openStream());

        int i = 0;

        try {
            knapsack_size = s.nextInt();
            size = s.nextInt();
            v = new int[size];
            w = new int[size];

            while (true) {
                v[i] = s.nextInt();
                w[i] = s.nextInt();
                i++;
            }
        } catch(NoSuchElementException e) {}
    }

    public long calculateOptimal() {
       // Arrays.sort(v);
        int[][] A = new int[size][knapsack_size];
        for (int j = 0; j < knapsack_size; j++) {
            A[0][j] = 0;
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < knapsack_size; j++) {
                if (w[i] <= j)
                    A[i][j] = Math.max(A[i-1][j], A[i-1][j-w[i]] + v[i]);
                else
                    A[i][j] = A[i-1][j];
            }
        }
        return A[size - 1][knapsack_size - 1];
    }

    public long calculateOptimal2() {
        int[] A = new int[knapsack_size+1];
        for (int i = 1; i < size; i++) {
            for (int j = knapsack_size; j >= w[i]; j--) {
                    A[j] = Math.max(A[j], A[j - w[i]] + v[i]);
            }
        }
        return A[knapsack_size];
    }

    private long calc(int s, int W) {
        if((s <= 0) || (W<= 0)) return 0;
        System.out.println(s+" "+ W);
        return Math.max(calc(s - 1, W), v[s-1] + calc(s - 1, W - w[s-1]));
    }

   /*
    public long calculateOptimal2() {
        return Math.max(exclude(0, knapsack_size), include(0, knapsack_size));
    }

    private long exclude(int s, int W) {
        if(s >= size -1) return 0;
        if(weights[s+1] > W) return exclude(s + 1, W);
        return Math.max(exclude(s + 1, W), include(s + 1, W));
    }

    private long include(int s, int W) {
        if(s >= size -1) return values[s];
        if(weights[s+1] > W) return values[s] + exclude(s + 1, W - weights[s]);
        return values[s] + Math.max(exclude(s + 1, W - weights[s]), include(s + 1, W - weights[s]));
    }

 */
}
