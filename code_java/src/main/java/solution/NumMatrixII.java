package solution;

/**
 * 这道题有两种方法
 * 1，2D BIT
 * 2，按行扫描，每一行都保存该行从左往右的和
 * 参考https://discuss.leetcode.com/topic/30343/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
 */
public class NumMatrixII {

    private int m, n;

    private int[][] tree;
    private int[][] nums;

    public NumMatrixII(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        m = matrix.length;
        n = matrix[0].length;
        nums = new int[m][n];
        tree = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) {
            return;
        }
        int delta = val - nums[row][col];
        nums[row][col] = val;

        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= i & (-i)) {
            for (int j = col + 1; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1);
    }

    /**
    private int[][] mMatrix;
    private int mRow, mCol;

    public solution.NumMatrixII(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        mRow = matrix.length;
        mCol = matrix[0].length;

        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mCol; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        mMatrix = matrix;
    }

    public void update(int row, int col, int val) {
        int orig = mMatrix[row][col] - (col > 0 ? mMatrix[row][col - 1] : 0);
        int delta = val - orig;
        for (int i = col; i < mCol; i++) {
            mMatrix[row][i] += delta;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += mMatrix[i][col2] - (col1 > 0 ? mMatrix[i][col1 - 1] : 0);
        }
        return sum;
    }*/
}
