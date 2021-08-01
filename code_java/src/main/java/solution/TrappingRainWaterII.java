package solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 思路是从外围开始，选择最短的柱子，以该柱子为标准，计算其四周的柱子所能容纳的水，并且更新四周柱子的高度，并加到小堆中。
 * 为什么这样呢？一个柱子所能蓄的水和该柱子相邻的四根柱子有关，所以我们从边界开始，不断向中间靠拢，每次都取队列中最短的那根柱子计算
 */
public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) {
            return 0;
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int row = heightMap.length, col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            queue.add(new int[] {0, i, heightMap[0][i]});
            queue.add(new int[] {row - 1, i, heightMap[row - 1][i]});
            visited[0][i] = true;
            visited[row - 1][i] = true;
        }
        for (int i = 0; i < row; i++) {
            queue.add(new int[] {i, 0, heightMap[i][0]});
            queue.add(new int[] {i, col - 1, heightMap[i][col - 1]});
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }
        int res = 0;
        int[][] delta = new int[][] {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1], z = node[2];
            for (int i = 0; i < delta.length; i++) {
                int xx = x + delta[i][0], yy = y + delta[i][1];
                if (xx >= 0 && xx < row && yy >= 0 && yy < col && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    res += Math.max(0, z - heightMap[xx][yy]);
                    /**
                     * 这里要更新柱子的高度，因为水平面肯定是Math.max(z, heightMap[xx][yy])
                     */
                    queue.add(new int[] {xx, yy, Math.max(z, heightMap[xx][yy])});
                }
            }
        }
        return res;
    }
}
