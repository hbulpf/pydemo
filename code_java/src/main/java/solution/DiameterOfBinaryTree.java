package solution;

import common.enties.TreeNode;

public class DiameterOfBinaryTree {

    /**
     * 这题和 124. Binary Tree Maximum Path Sum比较像
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, new int[1]) - 1;
    }

    /**
     * len表示带上root的最大深度
     */
    private int dfs(TreeNode root, int[] len) {
        if (root == null) {
            return 0;
        }

        int[] lt = new int[1];
        int[] rt = new int[1];

        int left = dfs(root.left, lt);
        int right = dfs(root.right, rt);

        len[0] = Math.max(lt[0], rt[0]) + 1;

        return Math.max(Math.max(left, right), lt[0] + rt[0] + 1);
    }
}
