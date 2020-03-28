import java.util.HashMap;

public class PathSumIII {

    /**
     * 当root.val == Sum时，不要return，因为继续往下走可能有路径刚好加起来为0，典型的为[1,-2,1,-1]，目标和为-1
     * 这里隐藏了四条路径，[1,-2], [-2,1], [-1], [1,-2,1,-1]，如果在[1,-2]就return了，那就会掉了[1,-2,1,-1]
     * 可参考https://discuss.leetcode.com/category/562/path-sum-iii
     */

    /**
     * 有两种可能，算上当前root和不算当前root
     */
    public int pathSum(TreeNode root, int sum) {
        int[] count = new int[1];
        helperSum(root, sum, count);
        return count[0];
    }

    /**
     * 既可以算上，也可以不算上root
     */
    private void helperSum(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }

        // 算上root
        helper(root, sum, count);

        // 不算上root
        helperSum(root.left, sum, count);
        helperSum(root.right, sum, count);
    }

    /**
     * 算上root
     */
    private void helper(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count[0]++;
            // 这里不用返回，因为下面的路径和可能为0;
        }

        helper(root.left, sum - root.val, count);
        helper(root.right, sum - root.val, count);
    }

    /**
     * 更优化的写法，时间复杂度O(n)
     * 和Two Sum较类似，都是算出从root到当前节点的和，target为两段和的差值
     */
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int[] count = new int[1];
        helper(root, sum, 0, map, count);
        return count[0];
    }

    private void helper(TreeNode node, int target, int sum, HashMap<Integer, Integer> map, int[] count) {
        if (node == null) {
            return;
        }

        sum += node.val;
        if (map.containsKey(sum - target)) {
            count[0] += map.get(sum - target);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        helper(node.left, target, sum, map, count);
        helper(node.right, target, sum, map, count);

        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}
