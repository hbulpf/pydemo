public class MaximumSubarray {

    // dp[i]表示包含第i个元素时的最大和
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(i > 0 ? dp[i - 1] + nums[i] : nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /* 这里dp其实可以去掉，换成一个普通int变量即可
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev = Math.max(i > 0 ? prev + nums[i] : nums[i], nums[i]);
            max = Math.max(max, prev);
        }
        return max;
    }
    */
}
