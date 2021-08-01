package solution;

/**
 * https://leetcode.com/articles/redundant-connection/
 */
public class RedundantConnection {
    /**
     * 思路很简单，发现第一个联通的边时就是多余的
     * 时间复杂度O(n)，空间O(n)
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] arr = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            int from0 = find(arr, from), to0 = find(arr, to);
            if (from0 == to0) {
                return edge;
            }
            arr[from0] = to0;
        }
        return new int[2];
    }

    private int find(int[] nums, int i) {
        for ( ; nums[i] != i; i = nums[i]);
        return i;
    }
}
