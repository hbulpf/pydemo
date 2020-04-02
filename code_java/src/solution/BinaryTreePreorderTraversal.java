package solution;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                result.add(root.val);  // Add before going to children
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return result;
    }
}
