package solution;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int[] area = new int[1];
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                area[0] = 0;
                dfs(grid, i, j, area);
                max = Math.max(max, area[0]);
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j, int[] count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        count[0]++;
        dfs(grid, i + 1, j, count);
        dfs(grid, i - 1, j, count);
        dfs(grid, i, j + 1, count);
        dfs(grid, i, j - 1, count);
    }
}
