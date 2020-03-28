import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root.left);
        queue2.offer(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode left = queue1.poll();
            TreeNode right = queue2.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue1.offer(left.left);
            queue1.offer(left.right);
            queue2.offer(right.right);
            queue2.offer(right.left);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    /**
     * 基于isSymmetric2，不过只要一个queue就够了
     */
    public boolean isSymmetri3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    /**
     * 非递归写法
     */
    public boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        while (!stack1.isEmpty() || left != null) {
            if (left != null) {
                if (right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                stack1.push(left);
                stack2.push(right);
                left = left.left;
                right = right.right;
            } else {
                if (right != null) {
                    return false;
                }
                if (stack2.isEmpty()) {
                    return false;
                }
                left = stack1.pop().right;
                right = stack2.pop().left;
            }
        }
        return stack2.isEmpty() && right == null;
    }
}
