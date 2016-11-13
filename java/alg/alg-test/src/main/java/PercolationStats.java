public class PercolationStats {
    private static final double CONST = 1.96;
    private double[] x;
    private double mean;

    /**
     * perform T independent experiments on an N-by-N grid
     *
     * @param N greed size
     * @param T number of experiments
     */
    public PercolationStats(int N, int T) {
        if (N <= 0) throw new IllegalArgumentException("N cannot be less or equal 0");
        if (T <= 0) throw new IllegalArgumentException("T cannot be less or equal 0");
        x = new double[T];
        double sum = 0;
        for (int i = 0; i < T; i++) {
            int count = 0;
            Percolation p = new Percolation(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N) + 1;
                int col = StdRandom.uniform(N) + 1;
                while (p.isOpen(row, col)) {
                    row = StdRandom.uniform(N) + 1;
                    col = StdRandom.uniform(N) + 1;
                }
                p.open(row, col);
                count++;
            }
            x[i] = (double) count / (N * N);
            sum += x[i];
        }
        mean = sum / T;
    }

    /**
     * sample mean of percolation threshold
     *
     * @return mean of percolation threshold
     */
    public double mean() {
        return mean;
    }

    /**
     * sample standard deviation of percolation threshold
     *
     * @return standard deviation of percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(x);
    }

    /**
     * low  endpoint of 95% confidence interval
     *
     * @return low  endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        double deviation = CONST * stddev() / Math.sqrt(x.length);
        return mean - deviation;
    }

    /**
     * high endpoint of 95% confidence interval
     *
     * @return high endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        double deviation = CONST * stddev() / Math.sqrt(x.length);
        return mean + deviation;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two command-line arguments N and T.");
            return;
        }
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);
        System.out.printf("mean = %f%n", stats.mean());
        System.out.printf("stddev = %f%n", stats.stddev());
        System.out.printf("95%% confidence interval = %f %f%n", stats.confidenceLo(), stats.confidenceHi());
    }
}
