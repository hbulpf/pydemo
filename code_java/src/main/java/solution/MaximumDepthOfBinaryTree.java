package solution;

import common.enties.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
