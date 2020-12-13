package common.utils;

/**
 * 常用工具类
 */
public class CommonUtils {

    /**
     * 求最大值
     *
     * @param val
     * @return
     */
    public static int intGetMax(int... val) {
        int max = Integer.MIN_VALUE;
        for (int k : val) {
            max = Math.max(max, k);
        }
        return max;
    }

    /**
     * 字符串转成字符数组
     * @param strs
     * @return
     */
    public static char[][] str2Chars(String[] strs) {
        char[][] board = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            board[i] = strs[i].toCharArray();
        }
        return board;
    }
}
