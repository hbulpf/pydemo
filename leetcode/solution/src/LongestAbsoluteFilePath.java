import java.util.Stack;

public class LongestAbsoluteFilePath {

    // 耗时4ms
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (String line : input.split("\n")) {
            int depth = line.lastIndexOf("\t") + 1;
            while (stack.size() > depth) {
                stack.pop();
            }
            int parentLen = stack.isEmpty() ? 0 : stack.peek();
            int len = parentLen + line.length() - depth;
            if (line.contains(".")) {
                max = Math.max(len, max);
            } else {
                stack.push(len + 1);
            }
        }
        return max;
    }
}
