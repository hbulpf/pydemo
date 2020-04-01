package solution;

import common.TreeNode;

public class CountCompleteTreeNodes {

    /** 适合通用的二叉树，但是对于完全二叉树会超时
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return count;
    }*/

    // 119ms，最差复杂度是O((lgn)^2),最好是O(lgn)
    public int countNodes(TreeNode root) {
        int left = 0, right = 0;
        for (TreeNode node = root; node != null; node = node.left, left++);
        for (TreeNode node = root; node != null; node = node.right, right++);
        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
