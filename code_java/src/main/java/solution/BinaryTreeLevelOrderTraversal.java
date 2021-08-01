package solution;

import common.enties.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    // 耗时2ms
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        queue.add(root);

        List<Integer> cur = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (cur == null) {
                cur = new LinkedList<Integer>();
                result.add(cur);
            }

            cur.add(node.val);

            if (node.left != null) {
                next.add(node.left);
            }

            if (node.right != null) {
                next.add(node.right);
            }

            if (queue.isEmpty()) {
                Queue<TreeNode> temp = queue;
                queue = next;
                next = temp;
                cur = null; // 注意这里要置空
            }
        }

        return result;
    }
}
