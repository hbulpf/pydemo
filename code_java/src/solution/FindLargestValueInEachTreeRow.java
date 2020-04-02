package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        queue.offer(root);

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            max = Math.max(max, node.val);

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                list.add(max);
                queue.addAll(next);
                next.clear();
                max = Integer.MIN_VALUE;
            }
        }

        return list;
    }
}
