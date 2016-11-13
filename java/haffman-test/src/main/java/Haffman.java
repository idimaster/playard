import java.util.*;

/**
 * Created by fluff on 7/28/16.
 */
public class Haffman {

    static class FrequencyPairComparator implements Comparator<TreeNode> {
        public int compare(TreeNode o1, TreeNode o2) {
            if (o1.getFrequency() == o2.getFrequency()) return 0;
            return o1.getFrequency() > o2.getFrequency() ? 1 : -1;
        }
    }


    public byte[] encode(String input) {
        if (input == null) throw new IllegalArgumentException("input cannot be null");
        final Map<Character, TreeNode> index = new HashMap<Character, TreeNode>();
        PriorityQueue<TreeNode> queue = calculateFrequency(input, index);
        TreeNode root = buildHaffmanTree(queue);
        BitWriter writer = new BitWriter();
        char [] inputChars = input.toCharArray();
        for(int i = 0; i < input.length(); i++) {
            TreeNode leaf = index.get(inputChars[i]);
            List<Boolean> bits = leaf.getBits();
            for(int j = bits.size() - 1; j >= 0; j--) {
                writer.add(bits.get(j));
            }
        }
        return writer.getData();
    }

    public String decode(byte[] rawData) {

    }

    private TreeNode buildHaffmanTree(PriorityQueue<TreeNode> queue) {
        while (queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            TreeNode node = new TreeNode(left, right);
            queue.add(node);
        }
        return queue.poll();

    }

    private PriorityQueue<TreeNode> calculateFrequency(String input, Map<Character, TreeNode> index) {
        Map<Character, FrequencyPair> frequency = new HashMap<Character, FrequencyPair>();
        char [] inputChars = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (frequency.containsKey(inputChars[i])) {
                FrequencyPair pair = frequency.get(inputChars[i]);
                pair.frequency ++;
            } else {
                FrequencyPair pair = new FrequencyPair(inputChars[i]);
                pair.frequency = 1;
                frequency.put(inputChars[i], pair);
            }
        }
        // Sorting
        final PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>(new FrequencyPairComparator());
        for(final FrequencyPair pair : frequency.values()) {
            TreeNode node = new TreeNode(pair);
            queue.add(node);
            index.put(node.getData(), node);
        }
        return queue;
    }
}
