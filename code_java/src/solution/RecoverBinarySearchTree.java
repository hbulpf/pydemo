package solution;

import java.util.Stack;

public class RecoverBinarySearchTree {

    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }

    // Morris遍历
    private void inorder(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                detect(root);
                root = root.right;
            } else {
                TreeNode pre = root.left;
                for ( ; pre.right != null && pre.right != root; pre = pre.right);
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                } else {
                    pre.right = null;
                    detect(root);
                    root = root.right;
                }
            }
        }
    }

    private void inorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                detect(root);
                root = root.right;
            }
        }
    }

    private void detect(TreeNode node) {
        if (prev != null) {
            if (first == null && prev.val > node.val) {
                first = prev;
            }
            if (first != null && prev.val > node.val) {
                second = node;
            }
        }
        prev = node;
    }
}
