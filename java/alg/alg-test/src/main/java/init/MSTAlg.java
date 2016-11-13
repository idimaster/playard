package init;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Dnitry on 3/29/2015.
 */
public class MSTAlg {
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
    }

    public static class Graph {
        final private int nodeCount;
        final private Edge[] edges;

        public Graph (int nodeCount, Edge[] edges) {
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
            Edge [] array = null;
            try {
                nodeCount = s.nextInt();
                int size = s.nextInt();
                array = new Edge[size];
                while (true) {
                    int node1 = s.nextInt();
                    int node2 = s.nextInt();
                    int cost = s.nextInt();
                    array[i] = new Edge(node1-1, node2-1, cost);
                    i++;
                }
            } catch(NoSuchElementException e) {}
            return new Graph(nodeCount, array);
        }
    }

    public static class Tree {
        private long cost;
        private List<Edge> edges;

        public Tree (){
            cost = 0;
            edges = new ArrayList<Edge>();
        }

        public long getCost() {
            return cost;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        private void addEdge(Edge e) {
            cost += e.cost;
            edges.add(e);
        }
    }

    public Tree calculate(Graph graph) {
        List<List<Edge>> nodes = new ArrayList<List<Edge>>();
        for(int i=0; i<graph.nodeCount; i++) {
            nodes.add(new ArrayList<Edge>());
        }
        for(Edge e : graph.edges){
            addEdge(nodes, e.node1, e);
            addEdge(nodes, e.node2, e);
        }
        PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
        addAges(edges, nodes.get(0));
        nodes.set(0, null);
        int inserted = 1;
        Tree mst = new Tree();

        while (inserted < graph.nodeCount) {
            Edge min = edges.poll();
            List<Edge> links = getNode(nodes, min);
            if(links != null){
                mst.addEdge(min);
                addAges(edges, links);
                removeNode(nodes, min);
                inserted++;
            }
        }
        return mst;
    }

    static private void addEdge(List<List<Edge>> nodes, int node, Edge e) {
        if(nodes.get(node) == null)
            nodes.set(node, new ArrayList<Edge>());
        nodes.get(node).add(e);
    }

    static private void addAges(PriorityQueue<Edge> edges, List<Edge> connected) {
        for(Edge e: connected) {
            edges.add(e);
        }
    }

    static private List<Edge> getNode(List<List<Edge>> nodes, Edge e) {
        if(nodes.get(e.node1) != null) {
            return nodes.get(e.node1);
        }
        return nodes.get(e.node2);
    }

    static private void removeNode(List<List<Edge>> nodes, Edge e) {
        if(nodes.get(e.node1) != null) {
            nodes.set(e.node1, null);
        }
        nodes.set(e.node2, null);
    }
}
