import java.util.Stack;

/**
 * https://leetcode.com/articles/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        int max = 0, cur = s.length();
        while (!stack.isEmpty()) {
            int prev = stack.pop();
            /**
             * (prev, cur)之间是合法部分，注意左右都是开区间
             */
            max = Math.max(cur - prev - 1, max);
            cur = prev;
        }

        /**
         * 栈空了，表示最后一个栈顶的左边都是合法部分了，即[0,end)之间是合法部分，这部分也要参与计算
         */
        return Math.max(max, cur);
    }
}
