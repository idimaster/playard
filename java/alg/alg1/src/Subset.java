public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        if (k == 0) return;
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        String[] strings = StdIn.readAllStrings();
        for (String s : strings) {
            queue.enqueue(s);
        }
        assert k <= queue.size();
        int i = 0;
        for (String str : queue) {
            StdOut.println(str);
            i++;
            if (i >= k) break;
        }
    }
}
