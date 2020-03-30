package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 经典的UF(Union Find)问题，可翻阅《算法》1.5章
 * UF时间复杂度和节点个数有关
 */
public class NumberOfIslandsII {

    private int[] mRoots;
    private int mCount;

    // 时间复杂度klgmn
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new LinkedList<Integer>();

        mRoots = new int[m * n];
        Arrays.fill(mRoots, -1);

        for (int[] p : positions) {
            int x = p[0], y = p[1], z = x * n + y;
            mRoots[z] = z;

            mCount++;

            int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
            for (int i = 0; i < dx.length; i++) {
                int x0 = x + dx[i], y0 = y + dy[i], z0 = x0 * n + y0;
                if (x0 < 0 || x0 >= m || y0 < 0 || y0 >= n || mRoots[z0] == -1) {
                    continue;
                }
                union(z, z0);
            }

            list.add(mCount);
        }

        return list;
    }

    private void union(int x, int y) {
        int x0 = findIsLand(x);
        int y0 = findIsLand(y);
        if (x0 != y0) {
            mRoots[x0] = y0;
            mCount--;
        }
    }

    private int findIsLand(int root) {
        while (root != mRoots[root]) {
            root = mRoots[root];
        }
        return root;
    }
}
