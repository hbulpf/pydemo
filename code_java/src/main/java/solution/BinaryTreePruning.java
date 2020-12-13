package solution;

import common.TreeNode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        return helper(root) ? root : null;
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.val == 1 || left || right;
    }
}
