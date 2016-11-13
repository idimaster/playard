public class Percolation {
    private final int N;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufB;
    private final boolean[] open;
    private final int TOP;
    private final int BOTTOM;

    /**
     * create N-by-N grid, with all sites blocked
     *
     * @param N grid size
     */
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("N cannot be less or equal 0");
        this.N = N;
        int size = N * N;
        this.uf = new WeightedQuickUnionUF(size + 1);
        this.ufB = new WeightedQuickUnionUF(size + 2);
        this.open = new boolean[size];
        TOP = size;
        BOTTOM = size + 1;
    }

    private void validate(int i, int j) {
        if (i < 1 || i > N) throw new IndexOutOfBoundsException("i must be between 1 and N");
        if (j < 1 || j > N) throw new IndexOutOfBoundsException("j must be between 1 and N");
    }

    private int getNodeId(int i, int j) {
        return (i - 1) * N + j - 1;
    }

    /**
     * open site (row i, column j) if it is not open already
     *
     * @param i row
     * @param j column
     */
    public void open(int i, int j) {
        validate(i, j);
        final int idx = getNodeId(i, j);
        if (open[idx]) return;
        open[idx] = true;
        if (i == N) ufB.union(idx, BOTTOM);
        if (i == 1) {
            uf.union(idx, TOP);
            ufB.union(idx, TOP);
        }
        if (j > 1 && open[idx - 1]) {
            uf.union(idx, idx - 1);
            ufB.union(idx, idx - 1);
        }
        if (j < N && open[idx + 1]) {
            uf.union(idx, idx + 1);
            ufB.union(idx, idx + 1);
        }
        if (i > 1 && open[idx - N]) {
            uf.union(idx, idx - N);
            ufB.union(idx, idx - N);
        }
        if (i < N && open[idx + N]) {
            uf.union(idx, idx + N);
            ufB.union(idx, idx + N);
        }
    }

    /**
     * is site (row i, column j) open?
     *
     * @param i row
     * @param j column
     * @return true if open
     */
    public boolean isOpen(int i, int j) {
        validate(i, j);
        final int idx = getNodeId(i, j);
        return open[idx];
    }

    /**
     * is site (row i, column j) full?
     *
     * @param i row
     * @param j col
     * @return true if full
     */
    public boolean isFull(int i, int j) {
        validate(i, j);
        final int idx = getNodeId(i, j);
        return uf.connected(idx, TOP);
    }

    /**
     * does the system percolate?
     *
     * @return true if percolates
     */
    public boolean percolates() {
        return ufB.connected(BOTTOM, TOP);
    }
}
