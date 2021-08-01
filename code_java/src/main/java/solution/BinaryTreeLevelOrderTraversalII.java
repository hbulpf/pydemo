package solution;

import common.enties.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    // 耗时2ms，和I一样，只不过加到result时添加到头
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        List<Integer> list = null;

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (list == null) {
                list = new ArrayList<>();
            }

            list.add(node.val);

            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                result.add(0, list);
                list = null;
            }
        }
        return result;
    }
}
