/**
 * https://leetcode.com/articles/range-sum-query-immutable/
 */
public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] + (i > 0 ? sums[i - 1] : 0);
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - (i > 0 ? sums[i - 1] : 0);
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
