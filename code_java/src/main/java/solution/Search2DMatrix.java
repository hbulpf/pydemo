package solution;

public class Search2DMatrix {

    // 耗时11ms
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int x = mid / col, y = mid % col;
            if (target == matrix[x][y]) {
                return true;
            } else if (target > matrix[x][y]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
