package solution;

public class DecodeString {

    /**
     * 一个函数搞定，思路很简单，利用一个栈，遇到不是']'则不断入栈，遇到']'则不断出栈，
     * 直到遇到'['，然后继续出栈数字，再将重复的字符串入栈
     */
    public static String decodeString(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.append(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.charAt(stack.length() - 1) != '[') {
                    sb.insert(0, stack.charAt(stack.length() - 1));
                    stack.setLength(stack.length() - 1);
                }
                stack.setLength(stack.length() - 1);
                int n = 0, t = 1;
                while (stack.length() > 0 && Character.isDigit(stack.charAt(stack.length() - 1))) {
                    n += t * (stack.charAt(stack.length() - 1) - '0');
                    t *= 10;
                    stack.setLength(stack.length() - 1);
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < sb.length(); j++) {
                        stack.append(sb.charAt(j));
                    }
                }
            }
        }
        return stack.toString();
    }

    // 耗时3ms，思路很直观，且不容易错，面试推荐写法
    public String decodeString2(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                sb.append(c);
            } else {
                String t = popString(sb);
                for (int i = popCount(sb); i > 0; i--) {
                    sb.append(t);
                }
            }
        }

        return sb.toString();
    }

    private String popString(StringBuilder sb) {
        StringBuilder ss = new StringBuilder();

        int i = sb.length() - 1;
        for ( ; sb.charAt(i) != '['; i--) {
            ss.append(sb.charAt(i));
        }
        sb.setLength(i);

        return ss.reverse().toString();
    }

    private int popCount(StringBuilder sb) {
        int i = sb.length() - 1, cnt = 0, t = 1;
        for ( ; i >= 0 && Character.isDigit(sb.charAt(i)); i--, t *= 10) {
            cnt += t * (sb.charAt(i) - '0');
        }
        sb.setLength(i + 1);
        return cnt;
    }
}
