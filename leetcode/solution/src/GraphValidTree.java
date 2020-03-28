/**
 * <p>
 * 判断无向图是否带环，可采用UF, DFS, BFS。
 * UF实现简单，性能很好
 * <p>
 * 题目中已声明不会有重复的边，类似[0,1]和[1,0]认为是重复的，也不会同时存在
 */
/**
 * 判断无向图是否带环，可采用UF, DFS, BFS。
 * UF实现简单，性能很好
 */
/**
 * 题目中已声明不会有重复的边，类似[0,1]和[1,0]认为是重复的，也不会同时存在
 */

import java.util.*;

/**
 * 这题就是给了一堆边，看这些边构成的无向图会不会有环，另外这些边是不是都连在一起的
 */
public class GraphValidTree {

    /**
     * 复杂度为O(VE)
     */
    // 耗时1ms
    public boolean validTree(int n, int[][] edges) {
        /**
         * 每个点都有一个另一个点指向它，唯独root是没有的，所以边数比点数少了1
         */
        if (edges.length != n - 1) {
            return false;
        }

        int[] nums = new int[n];

        /**
         * 先初始化这n个点都指向自己
         */
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            /**
             * 既然题目中已经说明不会有重复的边，所以如果x==y说明x和y已经有一条路径相通了，
             * 如果再多一条路径就要构成环了，所以这里直接return false
             */
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return true;
    }

    int find(int nums[], int i) {
        for (; nums[i] != i; i = nums[i]) ;
        return i;
    }


    /**
     * 采用DFS方法
     */
    // 耗时6ms
    public boolean validTree2(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        if (!dfs(graph, visited, 0, -1)) {
            return false;
        }
        return visited.size() == n;
    }

    /**
     * 采用DFS从某个点开始遍历整个图，
     * @start 当前节点
     * @parent 为了避免逆向遍历，因为parent肯定是访问过的，所以为了避免看作重复访问，这里排除了一下
     * @return 是否无环
     */
    private boolean dfs(List<Integer>[] graph, Set<Integer> visited, int start, int parent) {
        if (!visited.add(start)) {
            return false;
        }
        for (Integer to : graph[start]) {
            if (to != parent && !dfs(graph, visited, to, start)) {
                return false;
            }
        }
        return true;
    }

    /**
     * BFS
     */
    public boolean validTree3(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int k = queue.poll();

            for (Integer near : graph[k]) {
                if (!visited.add(near)) {
                    return false;
                }
                queue.offer(near);
                /**
                 * 这个remove别掉了，且必须是Integer.valueOf，
                 * 否则被当成index了
                 */
                graph[near].remove(Integer.valueOf(k));
            }
        }
        return visited.size() == n;
    }
}
