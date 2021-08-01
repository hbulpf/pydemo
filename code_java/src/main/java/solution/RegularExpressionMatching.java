package solution;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *  1. 递归法求解
 *  2. dp算法
 * 这道题最重要的是no bug，而不是性能
 * 要给所有cases cover到
 * 下面的写法足够简单和直观了
 * DP也可，但是不推荐
 *
 * @Author: RunAtWorld
 * @Date: 2020/4/7 23:26
 */

/**
 * TestCases
 * ".*"是可以匹配任意字符串的，因为".*"表示0个或多个"."，而"."是可以匹配任意字符的
 * *是不能单独存在的，前面必须跟一个字符，表示该字符出现0次或多次
 */
public class RegularExpressionMatching {

    /**
     * 递归法求解
     * 时间复杂度和空间复杂度较为难算
     * T=O((S+P)*2^(T+P/2))
     * O=O((S+P)*2^(T+P/2))
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //首字符匹配结果
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // p的长度>=2并第2个字符是 *
            // 情况1. p的第2个字符为*,p[0]*和s前面字符不匹配,p向后检查
            // 情况2. p的首字符匹配*和s首字符匹配,s向后再次匹配p
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        } else {
            //其他情况
            // 情况1. 首字符不匹配
            // 情况2. p.length()<2,但首字符匹配
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * 普通递归
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        } else if (p.length() == 1) {
            return s.length() == 1 && isEqual(s, p);
        } else if (p.charAt(1) != '*') {
            return s.length() > 0 && isEqual(s, p) && isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length() > 0 && isEqual(s, p)) {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }

    private boolean isEqual(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }
}
