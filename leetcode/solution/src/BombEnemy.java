public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, killedEnemies(grid, i, j));
                }
            }
        }
        return max;
    }

    private int killedEnemies(char[][] grid, int i, int j) {
        int count = 0;
        for (int k = j - 1; k >= 0 && grid[i][k] != 'W'; k--) {
            if (grid[i][k] == 'E') {
                count++;
            }
        }
        for (int k = j + 1; k < grid[0].length && grid[i][k] != 'W'; k++) {
            if (grid[i][k] == 'E') {
                count++;
            }
        }
        for (int k = i - 1; k >= 0 && grid[k][j] != 'W'; k--) {
            if (grid[k][j] == 'E') {
                count++;
            }
        }
        for (int k = i + 1; k < grid.length && grid[k][j] != 'W'; k++) {
            if (grid[k][j] == 'E') {
                count++;
            }
        }
        return count;
    }
}
