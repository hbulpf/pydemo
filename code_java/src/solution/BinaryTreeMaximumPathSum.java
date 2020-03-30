package solution;

import common.TreeNode;

/**
 * 单边的或者双边的，或只包含根节点的
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        return maxPathSum(root, null);
    }

    /**
     * max表示包含root的单边路径最大和
     */
    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return Integer.MIN_VALUE;  // 此处容易错
        }
        int[] left = new int[1], right = new int[1];
        int leftMax = maxPathSum(root.left, left);
        int rightMax = maxPathSum(root.right, right);
        if (max != null) {
            max[0] = max(left[0], right[0], 0) + root.val; // 此处容易错
        }

        // 容易错，要考虑到所有可能的情况
        return max(leftMax, rightMax, root.val, left[0] + right[0] + root.val,
                left[0] + root.val, right[0] + root.val);
    }

    private int max(int... vals) {
        int max = Integer.MIN_VALUE;
        for (int val : vals) {
            max = Math.max(max, val);
        }
        return max;
    }
}
