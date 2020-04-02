package solution;

public class BinaryTreeTilt {

    int tilt = 0;

    /**
     * 这题意思是遍历所有结点，对每个节点计算tilt，然后求和
     * 对于给定root，其tilt为左子树所有节点的和与右子树所有结点的和的差的绝对值
     */
    public int findTilt(TreeNode root) {
        helper(root);
        return tilt;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
