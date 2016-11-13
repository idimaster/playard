package top;

/**
 * Created by Dnitry on 6/21/2015.
 */
public class Aircraft {
    public static final String YES = "YES";
    public static final String NO = "NO";

    private static void validateInput(String var, int[] arr) {
        if (arr == null)
            throw new IllegalMonitorStateException(var + " cannot be null");
        if (arr.length != 3)
            throw new IllegalArgumentException(var + " must contain 3 elements");
        for (int i = 0; i < 3; i++){
            if(arr[i]<-10000 || arr[i]>10000)
                throw new IllegalMonitorStateException(var + " " + i +" element must be between -10000 and 10000");
        }
    }

    public String nearMiss(int[] p1, int[] v1, int[] p2, int[] v2, int R) {
        validateInput("p1", p1);
        validateInput("p2", p2);
        validateInput("v1", v1);
        validateInput("v2", v2);
        if(R < 0 || R > 10000) throw new IllegalArgumentException("R must be in range 0..10000");
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        int dz = p1[2] - p2[2];
        int dvx = v1[0] - v2[0];
        int dvy = v1[1] - v2[1];
        int dvz = v1[2] - v2[2];
        long a = (long)dvx*dvx + dvy*dvy + dvz*dvz;
        long b = (long)2*(dvx*dx + dvy*dy + dvz*dz);
        long c = (long)dx*dx + dy*dy + dz*dz - R*R;
        if (a == 0) {
            //bx + c = 0
            if(b == 0) {
                //c = 0
                return c != 0? YES:NO;
            } else {
                return -c/b >= 0? YES:NO;
            }
        }
        //ax2 + bx + c = 0
        long d = b*b - 4*a*c;
        if (d < 0) return NO;
        if (d == 0) return -b>=0 ?YES:NO;
        Double t = Math.sqrt(d);
        if (-b + d >= 0 || -b - d >= 0) return YES;
        return NO;
    }
}
