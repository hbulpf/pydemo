package solution;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    // 耗时2ms
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        helper(root, list, "");
        return list;
    }

    private void helper(TreeNode root, List<String> list, String path) {
        if (root == null) {
            return;
        }
        path += (path.isEmpty() ? "" : "->") + root.val;
        if (root.left == null && root.right == null) {
            list.add(path);
            return;
        }
        helper(root.left, list, path);
        helper(root.right, list, path);
    }
}
