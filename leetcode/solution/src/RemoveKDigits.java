/**
 * TestCase:
 * "10", 2
 */

/**
 * 思路很简单，就是从左到右遍历，找到第一个递增的拐点，假如是1121，则拐点是2，如果是2221，则拐点是最后一个2。
 * 另外要注意的是对于102，第一个拐点是1，删除后要给前面的0去掉，最终结果为2。
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        for (int i = 0, j; i < k && num.length() > 0; i++) {
            num = removeKdigits(num);
            for (j = 0; j < num.length() && num.charAt(j) == '0'; j++);
            num = num.substring(j);
        }
        return num.length() == 0 ? "0" : num;
    }

    public String removeKdigits(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (i + 1 < num.length()) {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    return num.substring(0, i) + num.substring(i + 1);
                }
            } else {
                return num.substring(0, i);
            }
        }
        return null;
    }
}
