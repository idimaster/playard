package interview2;

/**
 * Created by fluff on 7/7/16.
 */
/*
public class Balance {
    import java.util.Deque
    // { ( [ , ] , ) } -> balanced
// 1. ()
// 2. () -> balanced
// 1. ( // )
// 2. // () -> not balanced
// { ( { ) } } -> not balanced
    public class Brec

    boolean isBalanced(List<String> toBeParsed) {
        Deque<Char> stack = new Deque();
        for(String str : toBeParsed) {
            for(int i = 0; i < str.length(); i++) {
                if((str.charAt[i] == '{') || (str.charAt[i] == '(') || (str.charAt[i] == '[')) { // " }{([".indexOf(str.charAt[i])
                    stack.push(str.charAt[i]);
                }
                if((str.charAt[i] == '}') || (str.charAt[i] == ')') || (str.charAt[i] == ']')) {
                    char ch = stack.pop();
                    if (!openClosed(ch, str.charAt[i])) {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0 ;
    }

    boolean openClosed(char open, char close) {
        return (open =='{' && close == '}') || (open =='[' && close == ']') || (open =='(' && close == ')');
        // } -> {
        // ) -> (
        // ] -> [
        // " -> "
    }
}
*/