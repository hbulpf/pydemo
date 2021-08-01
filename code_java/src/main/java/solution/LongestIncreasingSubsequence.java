package solution;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * 这题是典型的DP，f[i]包含i的最长递增子序列长度
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n];
        /**
         * 注意这里fill是有必要的
         */
        Arrays.fill(f, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }

    /**
     * 核心思路是dp维护了一个递增的序列，dp[i]表示nums中长度为i+1的递增子序列中tail最小的值
     * tail越小意味着之后延长这个序列更容易
     * 为了保证dp[i]是tail最小的，我们遍历nums时，当发现有更小的值时，会替换dp[i]
     */
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
