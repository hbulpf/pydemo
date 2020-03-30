/**
 * 这题用的闭区间DP，dp[start][end]表示区间start,end内所有气球爆掉的最大coin
 * 假设最后爆第i个气球，start <= i <= end，则对应的coin为
 * coin = nums[start - 1] * nums[i] * nums[end + 1] + dp[start, i - 1] + dp[i + 1][end]
 * 为什么最后爆呢，因为这样以i为分隔线的左右两边就相互独立了，否则如果先爆i，则i的左右两个气球就相邻了
 * 为什么最后爆i时，其相邻值取nums[start - 1]和nums[end + 1]呢？放在全局来看，就是nums[-1]和nums[n]都为1
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start + len - 1 < n; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += i > start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.
                    coins += i < end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][n - 1];
    }

    private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
        if (i < 0 || i >= nums.length) {
            return 1;
        }
        return nums[i];
    }
}
