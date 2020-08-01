package solution;

import common.TreeNode;

public class ConstructBinaryTreeFromPreorderInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int index;
        for (index = inStart; index <= inEnd; index++) {
            if (inorder[index] == preorder[preStart]) {
                break;
            }
        }

        int len = index - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
