package solution;

import common.enties.TreeNode;

public class SubtreeOfAnotherTree {

    /**
     * 非递归的办法是拼成字符串，看是否是子串
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isEqual(s, t) || (s != null && (isSubtree(s.left, t) || isSubtree(s.right, t)));
    }

    private boolean isEqual(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return false;
        }
        return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }
}
