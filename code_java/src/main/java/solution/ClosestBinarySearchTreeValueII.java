package solution;

import common.enties.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 有三种解法：
 * 2，中序遍历两遍二叉树，不过每次都会中途退出，构成双栈，一个是大于target，一个是小于target，然后依次出栈满k为止，复杂度O(n + k)
 */
public class ClosestBinarySearchTreeValueII {

    // https://discuss.leetcode.com/topic/22940/ac-clean-java-solution-using-two-stacks/2
    // https://discuss.leetcode.com/topic/23151/o-logn-java-solution-with-two-stacks-following-hint


    /** 复杂度O(n + k)*/
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();

        inorderTraverse(preStack, root, target, false);
        inorderTraverse(postStack, root, target, true);

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (preStack.isEmpty()) {
                list.add(postStack.pop().val);
            } else if (postStack.isEmpty()) {
                list.add(preStack.pop().val);
            } else if (Math.abs(target - preStack.peek().val) < Math.abs(target - postStack.peek().val)) {
                list.add(preStack.pop().val);
            } else {
                list.add(postStack.pop().val);
            }
        }

        return list;
    }

    private void inorderTraverse(Stack<TreeNode> stack0, TreeNode root, double target, boolean reverse) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = reverse ? root.right : root.left;
            } else {
                TreeNode node = stack.pop();

                if ((reverse && node.val <= target) || (!reverse && node.val > target)) {
                    return;
                }

                stack0.push(node);
                root = reverse ? node.left : node.right;
            }
        }
    }

    /**
     * 形成双栈其实不用O(n)，当树是平衡二叉树时，有O(lgn)的写法，如下
     * 返回的是对于给定target，返回该target的所有successor和predesessor
     */
    public List<TreeNode> getAllSuccessor(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        buildSuccessorStack(root, stack, target);
        List<TreeNode> list = new LinkedList<>();
        TreeNode next;
        while ((next = getNextSuccessor(stack)) != null) {
            if (next.val != target) {
                list.add(next);
            }
        }
        return list;
    }

    private void buildSuccessorStack(TreeNode root, Stack<TreeNode> stack, int target) {
        for (TreeNode node = root; node != null; ) {
            if (target <= node.val) {
                stack.push(node);
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    /**
     * 右child的最左下角
     */
    private TreeNode getNextSuccessor(Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode ret = stack.pop();
        for (TreeNode node = ret.right; node != null; node = node.left) {
            stack.push(node);
        }
        return ret;
    }

    public List<TreeNode> getAllPredesessor(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        buildPredesessorStack(root, stack, target);
        List<TreeNode> list = new LinkedList<>();
        TreeNode next;
        while ((next = getNextPredesessor(stack)) != null) {
            if (next.val != target) {
                list.add(next);
            }
        }
        return list;
    }

    private void buildPredesessorStack(TreeNode root, Stack<TreeNode> stack, int target) {
        for (TreeNode node = root; node != null; ) {
            if (target >= node.val) {
                stack.push(node);
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    /**
     * 左child的最右下角
     */
    private TreeNode getNextPredesessor(Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode ret = stack.pop();
        for (TreeNode node = ret.left; node != null; node = node.right) {
            stack.push(node);
        }
        return ret;
    }

    /**
     * 结合上面的代码，可以有如下写法：
     */
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();

        for (TreeNode node = root; node != null; ) {
            if (target <= node.val) {
                postStack.push(node);
                node = node.left;
            } else {
                preStack.push(node);
                node = node.right;
            }
        }

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (preStack.isEmpty()) {
                list.add(getNextSuccessor(postStack).val);
            } else if (postStack.isEmpty()) {
                list.add(getNextPredesessor(preStack).val);
            } else if (Math.abs(target - preStack.peek().val) < Math.abs(target - postStack.peek().val)) {
                list.add(getNextPredesessor(preStack).val);
            } else {
                list.add(getNextSuccessor(postStack).val);
            }
        }

        return list;
    }
}
