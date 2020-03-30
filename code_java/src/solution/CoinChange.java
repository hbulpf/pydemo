import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i - coin >= 0 && dp[i - coin] >= 0) {
                    int k = dp[i - coin] + 1;
                    dp[i] = dp[i] > 0 ? Math.min(dp[i], k) : k;
                }
            }
        }
        return dp[amount];
    }
}
