import java.util.*;
import java.util.stream.Collectors;

public class ValidParentheses {
    public boolean isValid(String s) {
        List<Character> open = Arrays.asList('{','(','[');
        List<Character> close = Arrays.asList('}',')',']');
        Deque<Character> chars = new ArrayDeque<>();
        try {
            for (char ch : s.toCharArray()) {
                if (open.contains(ch)) {
                    chars.push(ch);
                }
                if (close.contains(ch)) {
                    Character last = chars.pop();
                    Character opposite = open.get(close.indexOf(ch));
                    if (last != opposite) {
                        return false;
                    }
                }
            }
        } catch (NoSuchElementException ex) {
            return false;
        return chars.isEmpty();
    }

    public boolean isValid2(String s) {
            String str = s.chars().filter(c -> c >= 'a' && c <= 'z')
                    .mapToObj(c -> Character.toString((char)c))
                    .collect(Collectors.joining());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(10, (o1, o2) -> Integer.compare(o1, o2));

        List<Character> open = Arrays.asList('{', '(', '[');
        List<Character> close = Arrays.asList('}', ')', ']');
        Deque<Character> chars = new ArrayDeque<>();
        s.chars()
            .mapToObj(o -> (char) o)
            .filter(c -> open.contains(c) || close.contains(c))
            .forEach(c -> {
                if (open.contains(c)) {
                    chars.push(c);
                } else {
                    chars.pop();
                }
        }});
    }
}
