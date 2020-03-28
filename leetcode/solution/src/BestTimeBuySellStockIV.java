public class BestTimeBuySellStockIV {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (k >= len) {
            int sum = 0;
            for (int i = 1; i < len; i++) {
                sum += Math.max(0, prices[i] - prices[i - 1]);
            }
            return sum;
        }

        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(0, diff), local[i - 1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }

        return global[len - 1][k];
    }
}
