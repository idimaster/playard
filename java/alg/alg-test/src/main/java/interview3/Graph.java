package interview3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by idimaster on 5/6/2017.
 */
public class Graph {
    private Map<String, Node> nodes;

    public Graph() {
        this.nodes = new HashMap<String, Node>();
    }

    public void addEdge(Edge e) {
        Node node = this.nodes.get(e.from);
        if (node == null) {
            node = new Node(e.from);
            nodes.put(node.id, node);
        }
        node.out.add(e.to);
        node = this.nodes.get(e.to);
        if (node == null) {
            node = new Node(e.to);
            nodes.put(node.id, node);
        }
        node.incInCount();
    }

    public String[] flatter() {
        String[] result = flatterStream(nodes.values()
                .stream()
                .map(Node::new))
                .toArray(String[]::new);
        if (result.length != nodes.size())
            return new String[0];
        return result;
    }

   private Stream<String> flatterStream(Stream<Node> stream) {
        List<Node> filtered = stream.filter(n -> n.getInCount() == 0).collect(Collectors.toList());
        if (filtered.isEmpty())
            return Stream.empty();
        return Stream.concat(
                filtered.stream().map(n -> n.id),
                flatterStream(filtered.stream().flatMap(n ->  n.out.stream())
                        .map(id -> {
                            Node n = nodes.get(id);
                            n.decInCount();
                            return n;
                        }))
        );
    }
}
