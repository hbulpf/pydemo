/**
 * https://segmentfault.com/a/1190000003059361
 */
public class ShortestPalindrome {
    /**
     * 其实只要将s与s的逆序串拼接在一起，求最长公共子串
     * 逆序串中从末尾刨除这个最长公共子串，就是要加到s前面的部分
     * 比如对abcd，其逆序为dcba，拼接为abcddcba，最长公共子串为a，因此dcba刨除a后为dcb，即为要加到abcd前面的部分
     */
    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return getCommonLength(str + rev, str.length());
    }

    private int getCommonLength(String s, int max) {
        for (int i = s.length() - max; i < s.length(); i++) {
            if (s.startsWith(s.substring(i))) {
                return s.length() - i;
            }
        }
        return 0;
    }
}
