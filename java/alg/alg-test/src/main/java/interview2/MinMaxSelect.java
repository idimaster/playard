package interview2;

/**
 * Created by fluff on 7/7/16.
 */
public class MinMaxSelect {
    private final double[] list;

    public MinMaxSelect(double[] list) {
        if (list == null) throw new IllegalArgumentException("list cannot be null");
        if (list.length == 0) throw new IllegalArgumentException("list cannot be empty");
        this.list = list;
    }

    public double min() {
        double min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
            }
        }
        return min;
    }

    public double max() {
        double max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
}
