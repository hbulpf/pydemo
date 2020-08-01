/**
 * 运动会，任意3排，抽方阵
 * 学校开运动会，队伍是 N*3 的 矩阵, 从其中选出 3 排，组成一个方阵，使得 3*3 的方阵是对称的。
 * 问: 有多少种抽法?
 *
 */
public class Main3 {
    public int numWay(String[] grid) {
        int len = grid.length;
        String[] matrix;
        int res = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    matrix = new String[3];
                    matrix[0] = grid[i];
                    matrix[1] = grid[j];
                    matrix[2] = grid[k];
                    res += getNum(matrix);
                }
            }
        }
        return res;
    }

    public int getNum(String[] matrix) {
        if (matrix.length > 3) {
            return 0;
        }
        int count = 0;

        String[] newMatrix;
        if (checkMatrix(matrix)&&matrix[0].equals(matrix[1])) {
            count++;

            return count;
        }
        for (int i = 0; i < 3; i++) {
            newMatrix = new String[3];
            newMatrix[0] = matrix[i];
            newMatrix[1] = matrix[(i + 1) % 3];
            newMatrix[2] = matrix[(i + 2) % 3];
            if (checkMatrix(newMatrix)) {
                count++;
            }
        }
        for (int i = 0; i < 3; i++) {
            newMatrix = new String[3];
            newMatrix[0] = matrix[i];
            newMatrix[1] = matrix[(i + 2) % 3];
            newMatrix[2] = matrix[(i + 1) % 3];
            if (checkMatrix(newMatrix)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkMatrix(String[] matrix) {
        boolean ok = true;
        ok = ok && (matrix[1].charAt(0) == matrix[0].charAt(1));
        ok = ok && (matrix[2].charAt(0) == matrix[0].charAt(2));
        ok = ok && (matrix[2].charAt(1) == matrix[1].charAt(2));
        return ok;
    }
}
