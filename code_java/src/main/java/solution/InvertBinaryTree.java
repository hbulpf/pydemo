package solution;

import common.enties.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给非递归法也要会写
 * 核心思路就是访问所有的节点，将其左右节点交换，可以采用递归，也可以BFS
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }
}
