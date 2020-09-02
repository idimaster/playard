package init;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Dmitry on 5/3/2015.
 */
public class TSPDynamic {

    static class Point {
        private final double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point[] points;
    private float[][] distances;
    private float[][] A;

    public int getCount(){
        return points.length;
    }

    public void load(URL url) throws IOException {
        Scanner s = new Scanner(url.openStream());

        int i = 0;
        try {
            int size = s.nextInt();
            points = new Point[size];
            while (true) {
                double x = s.nextDouble();
                double y = s.nextDouble();
                points[i] = new Point(x, y);
                i++;
            }
        } catch(NoSuchElementException e) {}
    }

    public float calculate() {
        calcDistances();
        int size = 1<<points.length;
        A = new float[size+1][points.length + 1];
        A[1][1] = 0;
        for (int i = 2; i <= size; i++) {
            A[i][1] = Float.POSITIVE_INFINITY;
        }
        for (int m = 2; m <= points.length; m++) {
            for (int i = 1; i <= size; i++) {
                if (Integer.bitCount(i) == m && (i&1) !=0) {
                    for (int j = 2; j <= points.length; j++) {
                        if (((i&(1<<(j-1)))!= 0)&& i != j) {
                            float min = Float.POSITIVE_INFINITY;
                            for(int k = 1; k <= points.length; k++){
                                if(k != j && ((i&(1<<(k-1)))!= 0)) {
                                    int s = i&(~(1<<(j-1)));
                                    float v = A[s][k] + distances[k-1][j-1];
                                    if(min > v) {
                                        min = v;
                                    }
                                }
                            }
                            A[i][j] = min;
                        }
                    }
                }
            }
        }
        float min = Float.POSITIVE_INFINITY;
        for (int i=2; i <= points.length; i++) {
            float v = A[size-1][i] + distances[i-1][0];
            if(min > v) {
                min = v;
            }
        }
        return min;
    }

    private void calcDistances() {
        distances = new float[points.length][points.length];
        for (int i=0; i < points.length; i++) {
            for (int j=0; j < points.length; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = distance(points[i], points[j]);  //TODO: remove 2x calculation
                }
            }
        }
    }

    private static float distance(Point a, Point b) {
        final double dx = a.x - b.x;
        final double dy = a.y - b.y;
        return (float)Math.sqrt(dx*dx + dy*dy);
    }

}
