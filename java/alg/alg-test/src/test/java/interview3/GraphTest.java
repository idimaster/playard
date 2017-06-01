package interview3;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by idimaster on 5/6/2017.
 */
public class GraphTest {
    @Test
    public void flatter0() {
        Graph g = new Graph();
        g.addEdge(new Edge("F", "B"));
        g.addEdge(new Edge("B", "H"));
        g.addEdge(new Edge("B", "A"));
        g.addEdge(new Edge("F", "C"));
        g.addEdge(new Edge("C", "A"));
        g.addEdge(new Edge("A", "E"));
        g.addEdge(new Edge("D", "G"));
        g.addEdge(new Edge("E", "C"));
        assertTrue(g.flatter().length == 0);
    }

    @Test
    public void flatter1() {
        Graph g = new Graph();
        g.addEdge(new Edge("F", "B"));
        g.addEdge(new Edge("B", "H"));
        g.addEdge(new Edge("B", "A"));
        g.addEdge(new Edge("F", "C"));
        g.addEdge(new Edge("C", "A"));
        g.addEdge(new Edge("A", "E"));
        g.addEdge(new Edge("D", "G"));
        assertTrue(g.flatter().length == 8);
    }
}
