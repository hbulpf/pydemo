package solution;

public class ValidateBinarySearchTree {

    // 耗时1ms
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        /**
         * root为null可以认为是合法的，如果是null为非法，则当某个节点没有子节点时，下面就返回false了，显然不对
         */
        if (root == null) {
            return true;
        }
        return root.val > lower && root.val < upper
                && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}
