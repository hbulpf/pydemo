package solution;

import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators {

    /**
     * 容易错的地方在于当组成数的时候高位为0是非法的
     * 另外start==0的时候要单独算
     * 为防止溢出，结果都要保存为long
     */
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<String>();
        if (num.length() == 0) {
            return result;
        }
        helper(num, target, result, "", 0, 0, 0);
        return result;
    }

    public void helper(String num, int target, List<String> result, String path, int index, long value, long last) {
        if (index == num.length()) {
            if (target == value) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            /**
             * 高位为0的数是非法的
             */
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                // 从pos=0开始的，所以不参与运算，只是组成第一个数
                helper(num, target, result, path + cur, i + 1, cur, cur);
            } else {
                helper(num, target, result, path + "+" + cur, i + 1, value + cur, cur);

                helper(num, target, result, path + "-" + cur, i + 1, value - cur, -cur);

                helper(num, target, result, path + "*" + cur, i + 1, value - last + last * cur, last * cur);
            }
        }
    }
}
