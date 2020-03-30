package solution;

public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, res);
        int right = dfs(node.right, res);

        int lval = 0, rval = 0;

        if (node.left != null && node.left.val == node.val) {
            lval = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rval = right + 1;
        }
        res[0] = Math.max(res[0], lval + rval);
        return Math.max(lval, rval);
    }
}
