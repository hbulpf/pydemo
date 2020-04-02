package solution;

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double min = Double.MAX_VALUE;

        for (TreeNode p = root; p != null; ) {
            double gap = Math.abs(target - p.val);
            if (gap < min) {
                min = gap;
                closest = p.val;
            }

            if (target > p.val) {
                p = p.right;
            } else if (target < p.val) {
                p = p.left;
            } else {
                break;
            }
        }

        return closest;
    }

    /**
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }*/
}
