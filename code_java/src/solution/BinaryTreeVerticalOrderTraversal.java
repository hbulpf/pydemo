import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

    private int minKey = 0, maxKey = 0;

    // 耗时6ms
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        HashMap<Integer, List<Integer>> map2 = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        map.put(root, 0);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int index = map.get(node);
            min = Math.min(min, index);
            max = Math.max(max, index);

            List<Integer> list = map2.get(index);
            if (list == null) {
                list = new LinkedList<Integer>();
                map2.put(index, list);
            }
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, index - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, index + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(map2.get(i));
        }
        return result;
    }
}
