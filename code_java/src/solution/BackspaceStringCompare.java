package solution;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            helper(stack1, S, i);
        }
        for (int i = 0; i < T.length(); i++) {
            helper(stack2, T, i);
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void helper(Stack<Character> stack, String s, int i) {
        if (i >= s.length()) {
            return;
        }
        char c = s.charAt(i);
        if (c == '#') {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(c);
        }
    }
}
