package init;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Dmitry on 4/12/2015.
 */
public class BinClustering {

    public static class Edge implements  Comparable{
        final private int node1;
        final private int node2;

        public Edge(int node1, int node2) {
            if(node1 > node2) {
                this.node1 = node2;
                this.node2 = node1;
            } else {
                this.node2 = node2;
                this.node1 = node1;
            }
        }

        @Override
        public int compareTo(Object o) {
            Edge e = (Edge)o;
            int thisCost = calcHammingDistance(this.node1, this.node2);
            int cost = calcHammingDistance(e.node1, e.node2);
            return Integer.compare(thisCost, cost);
        }

        private static int calcHammingDistance(int a, int b) {
            return Integer.bitCount(a ^ b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if ((node1 == edge.node1) && (node2 == edge.node2)) return true;
            if ((node1 == edge.node2) && (node2 == edge.node1)) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return node1 + node2;
        }
    }

    private Set<Integer> nodes = new HashSet<Integer>();
    private Set<Edge> edges = new HashSet<Edge>();
    private int andMask;
    private int andNotMask;
    private long nodeCount;

    public Set<Integer> getNodes() {
        return nodes;
    }

    public long getNodeCount() {
        return nodeCount;
    }

    public void load(URL url) throws IOException {
        Scanner s = new Scanner(url.openStream());

        nodeCount = 0;
        andMask = 0xffffff;
        andNotMask = 0xffffff;
        nodes.clear();
        try {
            nodeCount = s.nextInt();
            int bitCount = s.nextInt();
            while (true) {
                int node = 0;
                for (int i = 1; i <= bitCount; i++) {
                    int bit = s.nextInt();
                    node |= bit<<(bitCount - i);
                }
                nodes.add(node);
                andMask &= node;
                andNotMask &= ~node;
            }
        } catch(NoSuchElementException e) {}
        andNotMask &= 0xffffff;
    }

    public long calculate() {
        Integer[] list = nodes.toArray(new Integer[0]);
        List<Integer> dist = generate2bitDistances(24);
        Set<Integer> used = new HashSet<Integer>();
        edges.clear();
        for(int i = 0; i < list.length; i++) {
            for(int j = 0; j < dist.size(); j++) {
                int node = list[i] ^ dist.get(j);
                if (node!=list[i] && nodes.contains(node)) {
                    edges.add(new Edge(list[i], node));
                    used.add(node);
                    used.add(list[i]);
                }
            }
        }
        int missed = nodes.size() - used.size();
        used.clear();

        return missed + 1;
    }

    private static List<Integer> generate2bitDistances(int n){
        List<Integer>  distances = new ArrayList<Integer>();
        int dist = 1;
        for(int i = 0; i < n; i++) {
            distances.add(dist);
            dist<<=1;
        }
        int bit1 = 1;
        int bit2 = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                dist = bit1<<i | bit2<<j;
                distances.add(dist);
            }
        }
        return distances;
    }
}
