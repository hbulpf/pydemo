public class BinaryTreeUpsideDown {

    /**
     * 将root的左子树看作一个整体，root.left就作为倒置后的root和root.right的新parent
     * 注意若root的左子树为空，则无法倒置了，什么也不做
     * 注意最后要给root的左右清零
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;   // node 2 left children
        root.left.right = root;         // node 2 right children
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
