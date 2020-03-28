public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        helper(root, 0, res);
        return res[0];
    }

    private void helper(TreeNode node, int sum, int[] res) {
        if (node == null) {
            return;
        }

        int n = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            res[0] += n;
        } else {
            helper(node.left, n, res);
            helper(node.right, n, res);
        }
    }

}
