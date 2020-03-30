import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) {
            return result;
        }

        List<TreeNode> seq = new LinkedList<TreeNode>();
        List<TreeNode> tmp = new LinkedList<TreeNode>();

        seq.add(root);

        List<Integer> cur = new LinkedList<Integer>();

        for (int level = 1; !seq.isEmpty(); ) {
            TreeNode node = seq.remove(0);

            if (level % 2 != 0) {
                cur.add(node.val);
            } else {
                cur.add(0, node.val);
            }

            if (node.left != null) {
                tmp.add(node.left);
            }

            if (node.right != null) {
                tmp.add(node.right);
            }

            if (seq.isEmpty()) {
                result.add(cur);
                cur = new LinkedList<Integer>();
                List<TreeNode> tt = seq;
                seq = tmp;
                tmp = tt;
                level++;
            }
        }

        return result;
    }
}
