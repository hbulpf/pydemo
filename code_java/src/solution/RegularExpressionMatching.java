package solution; /**
 * 这道题最重要的是no bug，而不是性能
 * 要给所有cases cover到
 * 下面的写法足够简单和直观了
 * DP也可，但是不推荐
 */

/**
 * TestCases
 * ".*"是可以匹配任意字符串的，因为".*"表示0个或多个"."，而"."是可以匹配任意字符的
 * *是不能单独存在的，前面必须跟一个字符，表示该字符出现0次或多次
 */
public class RegularExpressionMatching {

    // 耗时153ms
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
