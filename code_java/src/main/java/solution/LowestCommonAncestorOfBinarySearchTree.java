package solution;

import common.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {

    /**
     * 假如不保证树中有p和q存在呢？
     */

    // 耗时9ms
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (!checkExist(root, p) || !checkExist(root, q)) {
            throw new IllegalArgumentException("Not exist!!");
        }

        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 如何判断p或q一定存在，如果是BST就很简单
     */
    private boolean checkExist(TreeNode root, TreeNode node) {
        TreeNode cur = root;
        while (cur != null) {
            if (node.val > cur.val) {
                cur = cur.right;
            } else if (node.val < cur.val) {
                cur = cur.left;
            } else {
                return true;
            }
        }
        return false;
    }
}
