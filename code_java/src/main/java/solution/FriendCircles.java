package solution;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int num = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                dfs(M, i);
                num++;
            }
        }
        return num;
    }

    /**
     * M[i][i] = 0表示第i个人我们已经访问过了
     * 访问过的人无需重复访问
     */
    private void dfs(int[][] M, int i) {
        M[i][i] = 0;
        for (int j = 0; j < M.length; j++) {
            if (M[j][j] != 0 && M[i][j] == 1) {
                dfs(M, j);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    class UnionFind {
        int[] path;
        int count;

        public UnionFind(int n) {
            path = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                path[i] = i;
            }
        }

        public int find(int i) {
            while (i != path[i]) i = path[i];
            return i;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) return;
            path[rootI] = rootJ;
            count--;
        }

        public int count() {
            return count;
        }
    }
}
