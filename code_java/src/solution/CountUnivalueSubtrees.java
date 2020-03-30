package solution;

public class CountUnivalueSubtrees {

    /**
     * 先分别判断左右子树是不是unival，如果是再判断带上root后是不是unival
     */
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    boolean helper(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }

        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);

        if (left && right) {
            if (root.left != null && root.left.val != root.val) {
                return false;
            }
            if (root.right != null && root.right.val != root.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
