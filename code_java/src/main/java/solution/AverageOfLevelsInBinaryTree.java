package solution;

import common.enties.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        List<Double> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);

        double sum = 0.0;
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            sum += node.val;
            count++;

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                result.add(sum / count);
                sum = 0.0;
                count = 0;
                queue.addAll(next);
                next.clear();
            }
        }

        return result;
    }
}
