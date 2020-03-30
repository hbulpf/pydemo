import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 有两种方法，用栈做普通的中序遍历，这种没有充分利用BST的特点
 * 第二种方法比较巧妙，首先遍历到p，然后继续遍历找到p的右子树的最小值
 */
public class InorderSuccessorInBST {

    // 耗时10ms
    // 时间复杂度O(n)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = null, prev = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prev == p) {
                    return node;
                }
                prev = node;
                node = node.right;
            }
        }
        return null;
    }

    // 耗时2ms，简单的递归写法，更容易理解
    /**
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val) {
            TreeNode node = inorderSuccessor(root.left, p);
            return node != null ? node : root;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }

    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }*/

    // 给上面的递归换成迭代写法
    // 耗时4ms
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (p.val < root.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    /**
     * http://www.geeksforgeeks.org/?p=9999
     * 给定Node，求其successor，步骤如下：
     * 1， 如果Node.right != null，则在Node.right中找最小的那个节点，即从Node.right开始，最左下角的节点
     * 2， 如果Node.right == null，则不断往parent走，直到当前节点是其parent的左节点为止，其parent即为给定Node的successor
     */
    /*
    private TreeNode inOrderSuccessor(TreeNode root, TreeNode node) {
        if (node.right != null) {
            return minValue(node.right);
        }

        TreeNode parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

     private TreeNode minValue(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }*/

    /**
     * 这题如果改成给定一个节点，求出其之后的所有successor或predesessor
     * 以下可用于 #272. Closest Binary Search Tree Value II
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
}
