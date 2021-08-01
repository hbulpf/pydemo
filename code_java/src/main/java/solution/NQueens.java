package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        /**
         * 这里f[i]表示第i行皇后应该放置在第几列
         */
        int[] f = new int[n];
        dfs(f, result, 0);
        return result;
    }

    private void dfs(int[] f, List<List<String>> result, int row) {
        if (row == f.length) {
            List<String> list = new LinkedList<>();
            char[] c = new char[f.length];
            for (int i = 0; i < f.length; i++) {
                Arrays.fill(c, '.');
                for (int j = 0; j < f.length; j++) {
                    if (j == f[i]) {
                        c[j] = 'Q';
                        break;
                    }
                }
                list.add(String.valueOf(c));
            }
            result.add(list);
        }
        /**
         * 对于当前第row行，一列一列地尝试放置皇后，看是否合法，j表示列，如果合法则保存到f中
         */
        for (int j = 0; j < f.length; j++) {
            if (isValid(f, row, j)) {
                /**
                 * 第row行皇后应该放置在第j列
                 */
                f[row] = j;
                /**
                 * 再来看下一行
                 */
                dfs(f, result, row + 1);
                /**
                 * 这里不用break，还要尝试其它可能
                 */
            }
        }
    }

    private boolean isValid(int[] f, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (f[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(f[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
