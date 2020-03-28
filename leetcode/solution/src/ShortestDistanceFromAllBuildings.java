import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    /**
     * 这道题思路是以所有建筑为根开始BFS，对所有覆盖到的点计算距离，
     * 每个空白点可能会同时被好几个建筑覆盖，所以其距离是叠加的，表示该点到那几个联通建筑的距离之和
     * 最后遍历所有空白点，求距离和最小的，同时能联通所有建筑的
     */

    /**
     * 1, 注意当没有结果时返回-1，而不是INT_MAX
     * 2, 要保证参考点能通往所有建筑，所以要统计建筑数
     * 3， bfs时要注意边界且别重复访问了
     */
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }
        int row = grid.length, col = grid[0].length;

        int[][] dis = new int[row][col];
        int[][] building = new int[row][col];
        int buildings = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                buildings++;
                bfs(grid, dis, building, i, j);
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && building[i][j] == buildings) {
                    shortest = Math.min(shortest, dis[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void bfs(int[][] grid, int[][] dis, int[][] building, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});

        Queue<int[]> next = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int level = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x0 = pos[0], y0 = pos[1];

            dis[x0][y0] += level;
            building[x0][y0]++;

            int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

            for (int m = 0; m < dx.length; m++) {
                int x = x0 + dx[m], y = y0 + dy[m];

                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                    continue;
                }

                if (grid[x][y] == 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    next.offer(new int[]{x, y});
                }
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                level++;
            }
        }
    }
}
