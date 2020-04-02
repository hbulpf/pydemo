package solution;

import java.util.Stack;

/**
 * https://leetcode.com/articles/convert-bst-to-greater-tree/
 */
public class ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                int s = sum;
                sum += node.val;
                node.val += s;
                node = node.left;
            }
        }
        return root;
    }
}
