import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfConnectedComponents {

    // 8ms
    public int countComponents(int n, int[][] edges) {
        int[] nums = new int[n];
        int count = n;
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x != y) {
                nums[x] = y;
                count--;
            }
        }
        return count;
    }

    private int find(int[] nums, int i) {
        for ( ; nums[i] != i; i = nums[i]);
        return i;
    }

    /**
     * DFS法
     */
    public int countComponents2(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(graph, i, visited);
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] graph, int i, Set<Integer> visited) {
        if (!visited.add(i)) {
            return;
        }
        for (Integer k : graph[i]) {
            dfs(graph, k, visited);
        }
    }
}
