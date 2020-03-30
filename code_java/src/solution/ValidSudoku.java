package solution;

import java.util.Arrays;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int row = board.length, col = board[0].length;

        boolean[] f = new boolean[9];

        for (int i = 0; i < row; i++) {
            Arrays.fill(f, false);

            for (int j = 0; j < col; j++) {
                if (!check(board[i][j], f)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < col; i++) {
            Arrays.fill(f, false);

            for (int j = 0; j < row; j++) {
                if (!check(board[j][i], f)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(f, false);

                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (!check(board[i * 3 + m][j * 3 + n], f)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean check(char c, boolean[] f) {
        if (c == '.') {
            return true;
        } else if (f[c - '1']) {
            return false;
        } else {
            f[c - '0'] = true;
            return true;
        }
    }
}
