import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    /**
     * 非递归，先序遍历一遍，再串起来
     */
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack();

        List<TreeNode> list = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public void flatten2(TreeNode root) {
        helper(root);
    }

    /**
     * 这题要注意ltail和rtail都为null的情况
     */
    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode ltail = helper(root.left);
        TreeNode rtail = helper(root.right);

        TreeNode right = root.right;

        if (ltail != null) {
            root.right = root.left;
            root.left = null;
            ltail.right = right;
        }

        return rtail != null ? rtail : ltail != null ? ltail : root;
    }
}
