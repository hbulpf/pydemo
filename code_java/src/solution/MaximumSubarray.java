package solution;

/**
 * 最大子序和
 * 1. DP算法 : T=O(N),S=O(1).利用nums数组本身作为DP数组
 * 2. 分治法
 *
 * @Author: RunAtWorld
 * @Date: 2020/4/4 22:36
 */
public class MaximumSubarray {

    /**
     * dp[i]表示包含第i个元素时的最大和
     * T=O(N),S=O(N).
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(i > 0 ? dp[i - 1] + nums[i] : nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 这里dp其实可以去掉，换成一个普通int变量即可,
     *  prev表示包含第i个元素时的最大和
     * T=O(N),S=O(1).
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev = Math.max(i > 0 ? prev + nums[i] : nums[i], nums[i]);
            max = Math.max(max, prev);
        }
        return max;
    }

    /**
     * DP算法 : T=O(N),S=O(1).
     * 利用nums数组本身作为DP数组,
     * nums[i]代表包含第i个元素的最大和
     *
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }
}
