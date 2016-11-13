package init;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Dnitry on 5/10/2015.
 */
public class TwoSAT2 {

    static class TwoClause {
        final int x;
        final int y;

        public TwoClause(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        final int x;
        final int y;
        TwoClause c;

        public Edge(int x, int y, TwoClause c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (x != edge.x) return false;
            return y == edge.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static class Vertex {
        Integer c;
        Integer comp;
        final List<Edge> edges;

        public Vertex() {
            edges = new ArrayList<Edge>();
        }
    }

    private List<TwoClause> clauses;
    private int vertCount = 0;
    private Vertex[] graph;
    private Deque<Integer> S = new ArrayDeque<Integer>();
    private Deque<Integer> P = new ArrayDeque<Integer>();
    private int c;
    private int comp;

    public int getVertCount() {
        return vertCount;
    }

    public int getCount() {
        return clauses.size();
    }

    public void load(URL url)throws IOException
    {
        Scanner s = new Scanner(url.openStream());

        try {
            int size = s.nextInt();
            clauses = new ArrayList<TwoClause>(size);
            vertCount = 0;
            while (true) {
                int node1 = s.nextInt();
                int node2 = s.nextInt();
                if(vertCount < Math.abs(node1)) {
                    vertCount = Math.abs(node1);
                }
                if(vertCount < Math.abs(node2)) {
                    vertCount = Math.abs(node2);
                }
                clauses.add(new TwoClause(node1, node2));
            }
        } catch (NoSuchElementException e) {
        }
    }

    private void createImplicationGraph() {
        graph = new Vertex[vertCount*2];
        for (TwoClause c : clauses) {
            int idxx = c.x > 0 ? 0 : 1;  //even is negative odd is positive
            int idxy = c.y > 0 ? 0 : 1;  //even is negative odd is positive
            int idx_x = (Math.abs(c.x) - 1)*2;
            int idx_y = (Math.abs(c.y) - 1)*2;
            if(graph[idx_x + idxx] == null) graph[idx_x + idxx] = new Vertex();
            if(graph[idx_y + idxy] == null) graph[idx_y + idxy] = new Vertex();
            if(graph[idx_y + 1 - idxy] == null) graph[idx_y + 1 - idxy] = new Vertex();
            if(graph[idx_x + 1 - idxx] == null) graph[idx_x + 1 - idxx] = new Vertex();
            graph[idx_x + idxx].edges.add(new Edge(idx_x + idxx, idx_y + 1 - idxy, c));
            graph[idx_y + idxy].edges.add(new Edge(idx_y + idxy, idx_x + 1 - idxx, c));
        }
    }

    public boolean calcSatisfiability() {
        c = 0;
        comp = 0;
        createImplicationGraph();
        for(int i = 0; i < graph.length; i++) {
            if(graph[i]!= null && graph[i].c == null) {
                if (DFS(i)) return false;
            }
        }
        return true;
    }

    private boolean DFS(int idx) {
        S.push(idx);
        P.push(idx);
        c++;
        graph[idx].c = c;
        for(Edge e : graph[idx].edges) {
            if(graph[e.y].c == null) { //did not processed by DFS
                if (DFS(e.y)) return true;
            } else {
                if(graph[e.y].comp == null) { //did not assigned to component
                    while (graph[P.peek()].c > graph[e.y].c) {
                        P.pop();
                    }
                }
            }
        }
        if (P.peek() == idx) {
            int compIdx = -1;
            Set duplCheck = new HashSet();
            do {
                compIdx = S.pop();
                graph[compIdx].comp = comp; //set component number
                int node = compIdx/2; 
                if(duplCheck.contains(node))
                    return true; //duplication detects, 2SAT cannot be satisfied
                duplCheck.add(node);
            } while (compIdx != idx);
            P.pop();
            comp ++;
        }
        return false;
    }
}
