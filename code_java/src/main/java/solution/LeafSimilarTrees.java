package solution;

import common.enties.TreeNode;

import java.util.Stack;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        TreeIterator iterator1 = new TreeIterator(root1);
        TreeIterator iterator2 = new TreeIterator(root2);

        while (true) {
            TreeNode node1 = iterator1.nextLeaf();
            TreeNode node2 = iterator2.nextLeaf();

            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
        }
    }

    public class TreeIterator {
        Stack<TreeNode> stack;
        TreeNode root;

        TreeIterator(TreeNode root) {
            this.root = root;
            stack = new Stack<>();
        }

        TreeNode nextLeaf() {
            TreeNode ret;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    ret = root;
                    root = root.left;

                    if (ret.left == null && ret.right == null) {
                        return ret;
                    }

                } else {
                    root = stack.pop().right;
                }
            }
            return null;
        }
    }
}
