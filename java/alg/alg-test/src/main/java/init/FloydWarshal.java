package init;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Dnitry on 4/26/2015.
 */
public class FloydWarshal   {

    public static class Edge implements  Comparable{
        final private int node1;
        final private int node2;
        final private int cost;

        public Edge(int node1, int node2, int cost)  {
            this.node2 = node2;
            this.node1 = node1;
            this.cost = cost;
        }

        @Override
        public int compareTo(Object o) {
            Edge e = (Edge)o;
            return Integer.compare(cost, e.cost);
        }
    }

    public static class Graph {
        final private int nodeCount;
        final private Edge[] edges;

        public Graph(int nodeCount, Edge[] edges) {
            this.nodeCount = nodeCount;
            this.edges = edges;
        }

        public int getNodeCount() {
            return nodeCount;
        }

        public Edge[] getEdges() {
            return edges;
        }

        static public Graph load(URL url) throws IOException {
            Scanner s = new Scanner(url.openStream());

            int i = 0;
            int nodeCount = 0;
            Edge[] array = null;
            try {
                nodeCount = s.nextInt();
                int size = s.nextInt();
                array = new Edge[size];
                while (true) {
                    int node1 = s.nextInt();
                    int node2 = s.nextInt();
                    int cost = s.nextInt();
                    array[i] = new Edge(node1 - 1, node2 - 1, cost);
                    i++;
                }
            } catch (NoSuchElementException e) {
            }
            return new Graph(nodeCount, array);
        }
    }

    public Integer calculate(Graph g) {
        Integer[][] data = new Integer[g.getNodeCount()][g.getNodeCount()];
        Integer minCost = Integer.MAX_VALUE;
        for (int i = 0; i < g.getNodeCount(); i++)
            for (int j = 0; j < g.getNodeCount(); j++) {
                data[i][j]= (i==j ? 0 : null);
            }
        for (Edge e : g.getEdges()) {
            data[e.node1][e.node2] = e.cost;
        }
        for (int k = 0; k < g.getNodeCount(); k++)
            for (int i = 0; i < g.getNodeCount(); i++)
                for (int j = 0; j < g.getNodeCount(); j++) {
                    if(data[i][k]!=null && data[k][j] != null) {
                        final int cost = data[i][k] + data[k][j];
                        if (data[i][j] == null || data[i][j] > cost) {
                            data[i][j] = cost;
                            if (minCost > cost) {
                                minCost = cost;
                            }
                        }
                        if ((i == j) && (data[i][j] < 0)) {
                            return null; //halt as graph has negative cycle
                        }
                    }
                }
        for (int i = 0; i < g.getNodeCount(); i++)
            for (int j = 0; j < g.getNodeCount(); j++) {
                if ((i == j) && (data[i][j] < 0)) {
                    return null; //halt as graph has negative cycle
                }
                if (data[i][j]!= null && minCost > data[i][j]) {
                    minCost = data[i][j];
                }
            }

        return minCost;
    }

    private static int getK(int k) {
        return  k%2;
    }

    public Integer calculate2(Graph g) {
        Double[][][] data = new Double[g.getNodeCount()][g.getNodeCount()][2];

        for (int i = 0; i < g.getNodeCount(); i++)
            for (int j = 0; j < g.getNodeCount(); j++) {
                data[i][j][0]= i==j ? 0 : Double.NaN;
            }
        for (Edge e : g.getEdges()) {
            data[e.node1][e.node2][0] = (double)e.cost;
        }
        for (int k = 1; k < g.getNodeCount()+1; k++)
            for (int i = 0; i < g.getNodeCount(); i++)
                for (int j = 0; j < g.getNodeCount(); j++) {
                    final double cost = data[i][getK(k)][getK(k-1)] + data[getK(k)][j][getK(k-1)];
                    if (data[i][j][getK(k-1)] > cost) {
                        data[i][j][getK(k)] = cost;
                    }
                    else {
                        data[i][j][getK(k)] = data[i][j][getK(k-1)];
                    }
                    if (i == j && data[i][j][getK(k)] < 0) {
                        return null; //halt as graph has negative cycle
                    }
                }
        Double minCost = (double)Integer.MAX_VALUE;
        for (int i = 0; i < g.getNodeCount(); i++)
            for (int j = 0; j < g.getNodeCount(); j++) {
                if (i == j && data[i][j][getK(g.getNodeCount())] < 0) {
                    return null; //halt as graph has negative cycle
                }
                if (minCost > data[i][j][getK(g.getNodeCount())]) {
                    minCost = data[i][j][getK(g.getNodeCount())];
                }
            }

        return minCost.intValue();
    }
}
