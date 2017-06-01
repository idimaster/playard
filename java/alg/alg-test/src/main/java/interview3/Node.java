package interview3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by idimaster on 5/6/2017.
 */
public class Node {
    final public String id;
    private int inCount;
    final public Set<String> out;

    public Node(String id) {
        this.id = id;
        this.inCount = 0;
        this.out = new HashSet<>();
    }

    public Node(Node n) {
        this.id = n.id;
        this.inCount = n.inCount;
        out = new HashSet<>(n.out);
    }

    public void incInCount() {
        this.inCount++;
    }

    public void decInCount() {
        if (this.inCount > 0)
            this.inCount--;
    }

    public int getInCount() {
        return inCount;
    }
}
