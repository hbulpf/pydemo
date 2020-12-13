package solution;

import common.enties.TreeNode;

/**
 * 平衡二叉树条件是左边是平衡，右边是平衡，且两边高度差相差不超过1
 * 树的高度是所有子树的最大高度
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, null);
    }

    private boolean isBalanced(TreeNode root, int[] height) {
        if (root == null) {
            return true;
        }

        int[] left = new int[1], right = new int[1];

        boolean result = isBalanced(root.left, left) && isBalanced(root.right, right);

        if (height != null) {
            height[0] = Math.max(left[0], right[0]) + 1;
        }

        return result && Math.abs(left[0] - right[0]) <= 1;
    }
}
