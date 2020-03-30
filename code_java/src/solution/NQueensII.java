package solution;

public class NQueensII {

    private int total;

    public int totalNQueens(int n) {
        int[] f = new int[n];
        dfs(f, 0);
        return total;
    }

    private void dfs(int[] f, int row) {
        if (row == f.length) {
            total++;
            return;
        }
        for (int j = 0; j < f.length; j++) {
            if (isValid(f, row, j)) {
                f[row] = j;
                dfs(f, row + 1);
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
