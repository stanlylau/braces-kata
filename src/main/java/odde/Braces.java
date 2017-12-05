package odde;

import java.util.HashSet;
import java.util.Stack;

public class Braces {

    static HashSet openBraces = new HashSet<Character>() {
        {
            add('{');
            add('[');
            add('(');
        }
    };

    static HashSet closedBraces = new HashSet<Character>() {
        {
            add('}');
            add(']');
            add(')');
        }
    };

    public static boolean isValid(String s) {
        if (!containsAcceptedBraces(s))
            return false;

        Stack<Character> stack = new Stack<>();
        for (char brace : s.toCharArray()) {
            if (isOpen(brace))
                stack.push(brace);

            if (isClosed(brace) && isOpen(stack.peek()))
                stack.pop();
        }

        return stack.empty();
    }

    private static boolean containsAcceptedBraces(String s) {
        for (char c : s.toCharArray())
            if (!(isOpen(c) || isClosed(c)))
                return false;
        return true;
    }

    private static boolean isClosed(char c) {
        return closedBraces.contains(c);
    }

    private static boolean isOpen(char c) {
        return openBraces.contains(c);
    }
}
