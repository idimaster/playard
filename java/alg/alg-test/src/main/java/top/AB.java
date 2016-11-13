package top;

/**
 * Created by Dnitry on 6/17/2015.
 */
public class AB {
    final String empty="";
    public String createString(int N, int K){
        if(N < 2 || N > 50) throw new IllegalArgumentException("N must be in range 2-50");
        if(K < 0 || K > N*(N-1)/2) throw new IllegalArgumentException("K must be in range 0-" + N*(N-1)/2);
        char [] ch = new char[N];
        for(int i = 0; i < N/2; i++) {
            ch[i] = 'B';
        }
        for(int i = N/2; i < N; i++) {
            ch[i] = 'A';
        }
        if(K == 0) {
            return new String(ch);
        }
        int cnt = 0;
        for(int k = 0; k < N-1; k++){
            for(int i = 0; i < N-1; i++) {
                if(ch[i]=='B'&&ch[i+1]=='A'){
                    ch[i] = 'A';
                    ch[i+1] = 'B';
                    cnt ++;
                    if(cnt == K)
                        return new String(ch);
                }
            }
        }
        return empty;
    }
}
