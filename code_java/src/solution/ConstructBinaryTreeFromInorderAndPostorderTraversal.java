package solution;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart >= inEnd || postStart >= postEnd) {
            return null;
        }

        int index = -1;

        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == postorder[postEnd - 1]) {
                index = i;
                break;
            }
        }

        if (index < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        root.left = buildTree(inorder, inStart, index, postorder, postStart, postStart + index - inStart);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + index - inStart, postEnd - 1);
        return root;
    }
}
