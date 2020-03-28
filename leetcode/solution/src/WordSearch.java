public class WordSearch {

    // 耗时9ms
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 容易错的地方在于要给start == word.length放在最前面
     * TestCase: "a", "a"
     */
    private boolean dfs(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] ^= '#';
        boolean flag = dfs(board, i + 1, j, word, start + 1)
                || dfs(board, i - 1, j, word, start + 1)
                || dfs(board, i, j + 1, word, start + 1)
                || dfs(board, i, j - 1, word, start + 1);
        board[i][j] ^= '#';
        return flag;
    }
}
