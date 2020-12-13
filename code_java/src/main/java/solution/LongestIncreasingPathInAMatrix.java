package solution; /**
 * https://leetcode.com/articles/longest-increasing-path-matrix/
 */

/**
 * 这题要注意缓存，否则会超时
 */
public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int max = 0;
        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }

        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        int max = 1;

        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            max = Math.max(max, dfs(matrix, x, y, cache) + 1);
        }

        cache[i][j] = max;
        return max;
    }
}
