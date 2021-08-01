package solution;

import common.enties.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        TreeNode target = null;

        queue.offer(root);

        boolean firstPoll = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (firstPoll) {
                firstPoll = false;
                target = node;
            }

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                firstPoll = true;
            }
        }

        return target.val;
    }
}
