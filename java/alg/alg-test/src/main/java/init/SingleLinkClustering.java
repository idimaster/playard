package init;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Dnitry on 4/11/2015.
 */
public class SingleLinkClustering {
    public static class Edge implements  Comparable{
        final private int node1;
        final private int node2;
        final private int cost;

        public Edge(int node1, int node2, int cost)  {
            if(node1 > node2) {
                this.node1 = node2;
                this.node2 = node1;
            } else {
                this.node2 = node2;
                this.node1 = node1;
            }
            this.cost = cost;
        }

        @Override
        public int compareTo(Object o) {
            Edge e = (Edge)o;
            return Integer.compare(cost, e.cost);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if(cost != edge.cost) return false;

            if ((node1 == edge.node1) && (node2 == edge.node2)) return true;
            if ((node1 == edge.node2) && (node2 == edge.node1)) return true;
            return false;
        }

        @Override
        public int hashCode() {
            int result = node1 + node2;
            result = 31 * result + cost;
            return result;
        }
    }

    public static class Graph {
        final private int nodeCount;
        final private List<Edge> edges;

        public Graph (int nodeCount, List<Edge> edges) {
            this.nodeCount = nodeCount;
            this.edges = edges;
        }

        public int getNodeCount() {
            return nodeCount;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        static public Graph load(URL url) throws IOException {
            Scanner s = new Scanner(url.openStream());

            int nodeCount = 0;
            List<Edge> array = new ArrayList<Edge>();
            try {
                nodeCount = s.nextInt();
                while (true) {
                    int node1 = s.nextInt();
                    int node2 = s.nextInt();
                    int cost = s.nextInt();
                    array.add(new Edge(node1-1, node2-1, cost));
                }
            } catch(NoSuchElementException e) {}
            return new Graph(nodeCount, array);
        }
    }

    static private class UFHolder {
        int parent;
        int count;
        List<UFHolder> children;

        public UFHolder(int parent, int count) {
            this.parent = parent;
            this.count = count;
            this.children = new ArrayList<UFHolder>();
            children.add(this);
        }
    }

    public long clustering(Graph graph, int count) {
        Collections.sort(graph.getEdges());
        List<UFHolder> nodes = new ArrayList<UFHolder>();
        for (int i = 0; i < graph.nodeCount; i++) {
            nodes.add(new UFHolder(i, 1));
        }
        int cCount = graph.nodeCount;
        for (int i = 0; i < graph.getEdges().size(); i++) {
            Edge edge = graph.getEdges().get(i);
            UFHolder left = nodes.get(edge.node1);
            UFHolder right = nodes.get(edge.node2);
            if(left.parent != right.parent) {
                //different clusters
                union(left, right);
                cCount--;
                if(cCount == count) return edge.cost;
            }
        }
        return 0;
    }

    private static void union(UFHolder left, UFHolder right) {
        if(left.count >= right.count) {
            left.count += right.count;
            for(UFHolder h: right.children) {
                h.parent = left.parent;
                h.count = left.count;
                left.children.add(h);
            }
        }  else {
            union(right, left);
        }
    }
}
