/**
 * 要注意栈判空
 */
public class ValidParentheses {

    // 耗时4ms
    public boolean isValid(String s) {
        int[] stack = new int[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack[index++] = i;
                    break;
                case ')':
                    if (index == 0 || s.charAt(stack[--index]) != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (index == 0 || s.charAt(stack[--index]) != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (index == 0 || s.charAt(stack[--index]) != '{') {
                        return false;
                    }
                    break;
            }
        }
        return index == 0;
    }
}
