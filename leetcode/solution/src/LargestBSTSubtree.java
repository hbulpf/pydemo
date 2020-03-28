public class LargestBSTSubtree {

    class Result {
        int count;
        int lower;
        int upper;

        Result(int count, int lower, int upper) {
            this.count = count;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        // 注意这里的等号千万别掉了，因为可能树中有节点相同
        if (left.count < 0 || right.count < 0 || left.upper >= root.val || right.lower <= root.val) {
            return new Result(-1, 0, 0);
        }

        int size = left.count + 1 + right.count;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
