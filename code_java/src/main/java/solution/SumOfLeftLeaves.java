package solution;

import common.enties.TreeNode;

import java.util.Stack;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            left = root.left.val;
        } else {
            left = sumOfLeftLeaves(root.left);
        }

        return left + sumOfLeftLeaves(root.right);
    }

    /**
     * 迭代法，遍历所有结点，判断是左叶子时加上
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int sum = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (root.left != null && root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                }

                root = root.right;
            }
        }
        return sum;
    }
}
