public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int row = matrix.length, col = matrix[0].length;

        boolean clearRow = false, clearCol = false;

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                clearRow = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                clearCol = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 注意这里是从1开始
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 注意这里是从1开始
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (clearRow) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

        if (clearCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
