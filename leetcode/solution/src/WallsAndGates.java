import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/articles/walls-and-gates/
 */

/**
 * 这题BFS我的思路总喜欢是从一个门开始，不停地bfs遍历完所有的房间，计算每个房间到这个门的距离，然后再
 * 从下一个门开始继续这样遍历，同时如果某个房间到这个门距离更短的话则更新距离，这样效率其实不高的。
 * 更好的办法是总体bfs，将所有的门加入队列作为队列的第一层，与第一层的门相邻的房间都标为1，同时这些房间作为
 * bfs的第二层，与第二层相邻的房间都标为2，要注意的是已经标过的房间肯定是该房间距离某个门的最近距离了，就直接跳过，
 * 只标那些INF的。
 */
public class WallsAndGates {

    // 耗时7ms
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        int row = rooms.length, col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }

        // 这个条件非常重要
        // 如果rooms[i][j]=0,dis=0，则这里可以继续走下去
        // 如果rooms[i][j]=0,dis!=0，则这里直接跳过，表示遇到另一个0了，那个门的情况我们不处理
        // 如果room[i][j]!=0,dis!=0,但是rooms[i][j]<dis，有两种情况，
        //      1. 一种是在当前dfs中该节点被访问过了，所以值会比dis小，这种情况下就别重复访问了
        //      2. 另一种是当前dfs没访问过，但是在另一个dfs中访问过了，该节点离另一个门比较近，所以这个节点会绕过，虽然这个节点
        // 的邻居节点本次没有访问，但是仍然会通过其他的路径访问到的，所以这里直接return没有影响。
        if (rooms[i][j] < dis) {
            return;
        }

        rooms[i][j] = dis;

        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
    }

    private void wallsAndGates2(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        int row = rooms.length, col = rooms[0].length;

        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            for (int i = 0; i < dx.length; i++) {
                int x0 = x + dx[i], y0 = y + dy[i];
                /**
                 * 设置过的肯定是最小的值，就不用再设置了
                 */
                if (x0 >= 0 && x0 < rooms.length && y0 >= 0 && y0 < rooms[0].length && rooms[x0][y0] == Integer.MAX_VALUE) {
                    rooms[x0][y0] = rooms[x][y] + 1;
                    queue.add(new int[] {x0, y0});
                }
            }
        }
    }
}
