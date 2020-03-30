public class HouseRobberIII {

    /**
     * 效率堪忧，耗时1000ms
     */
    public int rob(TreeNode root) {
        return rob(root, true);
    }

    /**
     * @param rob true表示不定，false表示不选root
     */
    private int rob(TreeNode root, boolean rob) {
        if (root == null) {
            return 0;
        }

        if (rob) {
            return Math.max(root.val + rob(root.left, false) + rob(root.right, false),
                    rob(root.left, true) + rob(root.right, true));
        } else {
            return rob(root.left, true) + rob(root.right, true);
        }
    }

    /**
     * 优化写法如下，耗时1ms
     * 这里将两种情况都保存下来并返回给上层，避免了多次重复计算
     * val[0]表示不rob当前节点，val[1]表示rob当前节点
     */
    public int rob2(TreeNode root) {
        int[] val = helper(root);
        return Math.max(val[0], val[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] value = new int[2];
        value[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        value[1] = node.val + left[0] + right[0];
        return value;
    }

}
