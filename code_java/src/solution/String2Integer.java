/**
 * 要求如下：
 * 1. 过滤掉前面的空格
 * 2. 考虑正负号
 * 3. 如果溢出则返回上限或下限
 * 4. 解析时遇到非法字符则停止，返回当前结果
 * 5，防御空串
 */

/**
 * TestCase: ""
 */
public class String2Integer {

    public int myAtoi(String str) {
        int i = 0, sign = 1;
        for ( ; i < str.length() && str.charAt(i) == ' '; i++);
        if (i < str.length()) {
            char csign = str.charAt(i);
            if (csign == '-') {
                sign = -1;
                i++;
            } else if (csign == '+') {
                sign = 1;
                i++;
            } else if (csign < '0' || csign > '9') {
                return 0;
            } else {}
        }
        long number = 0;
        for ( ; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            number = number * 10 + (c - '0');

            if (number * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (number * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (number * sign);
    }
}
