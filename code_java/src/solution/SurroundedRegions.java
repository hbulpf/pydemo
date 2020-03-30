package solution;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    /**
     * BFS法
     * 给与边界的O相邻的所有O点都标为+，然后剩下的O肯定是不与边界O相邻的，则必然是被X包围的，
     * 将这些O标为X后，再给剩下的+都还原为O即可
     */
    public void solve2(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < col; i++) {
            enqueue(board, 0, i, queue);
            enqueue(board, row - 1, i, queue);
        }
        for (int i = 0; i < row; i++) {
            enqueue(board, i, 0, queue);
            enqueue(board, i, col - 1, queue);
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            enqueue(board, x - 1, y, queue);
            enqueue(board, x + 1, y, queue);
            enqueue(board, x, y + 1, queue);
            enqueue(board, x, y - 1, queue);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void enqueue(char[][] board, int i, int j, Queue<int[]> queue) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {
            board[i][j] = '+';
            queue.add(new int[]{i, j});
        }
    }

    /**
     * DFS法
     * 数据量大时可能Stack Overflow
     */
    public void solve3(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;

        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '+';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
