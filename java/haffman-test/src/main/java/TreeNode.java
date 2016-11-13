import java.util.ArrayList;
import java.util.List;

/**
 * Created by fluff on 7/28/16.
 */
public class TreeNode {
    private final int frequency;
    private char data;
    private TreeNode left;
    private TreeNode right;
    ArrayList<Boolean> bits;

    public TreeNode(TreeNode left, TreeNode right) {
        if (left.frequency > right.frequency)
            throw new IllegalArgumentException("Frequency of left node cannot be higher than frequency of right node");
        this.frequency = left.getFrequency() + right.getFrequency();
        this.left = left;
        this.right = right;
        left.addBit(false);
        right.addBit(true);
    }

    public TreeNode(FrequencyPair pair) {
        if (pair == null) throw new IllegalArgumentException("pair cannot be null");
        this.frequency = pair.frequency;
        this.data = pair.key;
        this.bits = new ArrayList<Boolean>();
    }

    private void addBit(boolean value) {
        if (left != null) left.addBit(value);
        if (right != null) right.addBit(value);
        if (bits != null) bits.add(value);
    }

    public int getFrequency() {
        return frequency;
    }

    public char getData() {
        return data;
    }

    public List<Boolean> getBits() {
        return bits;
    }
}
