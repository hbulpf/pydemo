package solution;

/**
 * https://leetcode.com/articles/maximal-square/
 */
public class MaximalSquare {
    /**
     * 这题要返回的是面积
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length, col = matrix[0].length;

        int[][] f = new int[row][col];

        int max = 0;

        for (int i = 0; i < col; i++) {
            f[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, f[0][i]);
        }

        for (int i = 0; i < row; i++) {
            f[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, f[i][0]);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0') {
                    f[i][j] = 0;
                } else {
                    int mn = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.min(mn, f[i - 1][j - 1]) + 1;
                    max = Math.max(max, f[i][j]);
                }
            }
        }

        return max * max;
    }
}
