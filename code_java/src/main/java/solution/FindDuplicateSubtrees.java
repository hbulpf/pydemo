package solution;

import common.enties.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubtrees {

    /**
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        serialize(root, new HashMap<>(), result);
        return result;
    }

    private String serialize(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
        if (root == null) {
            return "X";
        }
        String s = root.val + "," + serialize(root.left, map, list) + "," + serialize(root.right, map, list);
        int count = map.getOrDefault(s, 0);
        if (count == 1) {
            list.add(root);
        }
        map.put(s, count + 1);
        return s;
    }
}
