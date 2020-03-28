/**
 * https://leetcode.com/articles/best-time-buy-and-sell-stock/
 */
public class BestTimeBuySellStock {
    /**
     * 注意这里maxProfit别初始化为Integer.MIN_VALUE，
     * 因为不一定要交易的，至少不亏钱
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0, min = Integer.MAX_VALUE;

        for (int price : prices) {
            int profit = price - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            min = Math.min(min, price);
        }

        return maxProfit;
    }
}
