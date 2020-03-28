import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/articles/two-sum-iv/
 */
public class TwoSumIV {

    /**
     * 先遍历一遍，生成一个递增序列，再从两端往中间检查
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int i = 0, j = nums.size() - 1; i < j; ) {
            if (nums.get(i) + nums.get(j) == k) return true;
            if (nums.get(i) + nums.get(j) < k) i++;
            else j--;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     * 更简单一点，遍历树，用一个hashset记录每个元素
     * 时间空间都是O(n)
     */
    public boolean findTarget2(TreeNode root, int k) {
        return visit(root, k, new HashSet<>());
    }

    private boolean visit(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return visit(root.left, k, set) || visit(root.right, k, set);
    }
}
