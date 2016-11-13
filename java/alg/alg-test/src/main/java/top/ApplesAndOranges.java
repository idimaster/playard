package top;

import java.util.Arrays;

/**
 * Created by Dmitry on 6/11/2015.
 * http://community.topcoder.com/stat?c=problem_statement&pm=13791
 */
public class ApplesAndOranges {
    public int maximumApples(int N, int K, int[] info){
        if(N < 2 || N > 2000)
            throw new IllegalArgumentException("N must be between 2 and 2000");
        if(K < 2 || K > N)
            throw new IllegalArgumentException("K must be between 2 and N");
        if(info == null || info.length > N)
            throw  new IllegalArgumentException("incorrect info");

        int [] fruits = new int[N];
        Arrays.fill(fruits, 2);   // may be orange
        for(int index: info) {
            assert index >= 1 : index <= N;
            fruits[index - 1] = 1;  // orange
        }
        int maxOranges = K/2;
        int oranges = 0;
        for (int i = 0; i <= N-K; i++){
            int count = 0;
            for (int k = i; k < i+K; k++) {
                if(fruits[k] > 0) count ++;
            }
            int conflicts = maxOranges >= count ? 0 : count - maxOranges;
            for(int k = i+K-1; k >=i && conflicts > 0; k--){
                if(fruits[k] > 1) {
                    fruits[k] = 0; //not an orange
                    conflicts--;
                }
            }
            if(fruits[i] > 0) oranges++;
        }
        for (int i = N-K+1; i < N; i++){
            if(fruits[i] > 0) oranges++;
        }
        return oranges;
    }
}
