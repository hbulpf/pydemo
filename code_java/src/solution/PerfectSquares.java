public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 1; i - k * k >= 0; k++) {
                min = Math.min(min, 1 + dp[i - k * k]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
