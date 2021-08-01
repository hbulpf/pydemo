package solution; /**
 * https://leetcode.com/articles/construct-string-from-binary-tree/
 */

import common.enties.TreeNode;

/**
 * 这题不难，主要是搞清楚题目意思
 * 即返回root + (左子树) + (右子树)
 * 不过要注意几个特殊情况，如果左右子树都为null，则只返回root
 * 如果左子树为null，右子树非null，则返回root + () + (右子树)
 * 如果左子树非null，右子树为null，则返回root + (左子树)
 */
public class ConstructStringFromBinaryTree {

    /**
     * 左子树如果为空'()'是不能省略的
     * 右子树如果为空可以省略
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        String left = "(" + tree2str(t.left) + ")";
        String right = t.right != null ? "(" + tree2str(t.right) + ")" : "";
        return t.val + left + right;
    }
}
