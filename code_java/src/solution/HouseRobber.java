public class HouseRobber {

    /**
     * 这里的dp表示统计到当前房子的最大收益，但是不确定要不要包含当前房子
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // dp意思是统计到当前房子为止的最大收益
        int[] dp = new int[n];

        // 这里要注意越界的问题
        for (int i = 0; i < n; i++) {
            dp[i] = Math.max(nums[i] + (i > 1 ? dp[i - 2] : 0), i > 0 ? dp[i - 1] : 0);
        }
        return dp[n - 1];
    }

    // 这个简洁
    public int rob2(int[] nums) {
        int prev = 0, cur = 0;
        for (int n : nums) {
            int temp = cur;
            cur = Math.max(n + prev, cur);
            prev = temp;
        }
        return cur;
    }
}
