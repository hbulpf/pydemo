package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        helper(root, sum, result, new LinkedList<>());
        return result;
    }

    private void helper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new ArrayList<>(list));
        } else {
            helper(node.left, sum - node.val, result, list);
            helper(node.right, sum - node.val, result, list);
        }

        list.remove(list.size() - 1);
    }
}
