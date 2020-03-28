public class BestTimeBuySellStockIII {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int min = prices[0];
        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[len - 1];
        int[] right = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < len; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
}
