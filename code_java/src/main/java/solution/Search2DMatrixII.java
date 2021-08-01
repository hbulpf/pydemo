package solution;

public class Search2DMatrixII {

    // 耗时14ms
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = matrix.length, col = matrix[0].length;

        for (int i = 0, j = col - 1; i < row && j >= 0; ) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
            }
        }

        return false;
    }
}
