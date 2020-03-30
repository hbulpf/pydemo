import java.util.*;

public class BinaryTreePostorderTraversal {

    /**
     * 先序是中左右，中序是左中右，后序是左右中，所以我们可以给先序调整一下改成中右左，然后倒过来就成了左右中
     * @param root
     * @return
     */
    // 这里虽然最后的结果返回的是对的，但真正访问节点的顺序是不对的，root并不是最后访问的
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                results.add(0, root.val);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }
        return results;
    }

    // root为null表示栈顶的左子树都访问完了，该看右子树了
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        for (TreeNode last = null; !stack.isEmpty() || root != null; ) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && last != peek.right) {
                    root = peek.right; // 只有这里要设置root
                } else {
                    result.add(peek.val);
                    last = stack.pop();
                    // 此时root仍为null
                }
            }
        }

        return result;
    }
}
