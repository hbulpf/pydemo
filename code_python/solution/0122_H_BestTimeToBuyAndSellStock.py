class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        dp 思想: 
        dp[i][0] 表示当日不持有股票的最大收益, dp[i][1] 表示当日持有股票的最大收益
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
        """
        if not prices:
            return 0
        dp = [[0, 0]] * len(prices)
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1, len(prices)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        return max(dp[len(prices) - 1][0], dp[len(prices) - 1][1])

    def maxProfit2(self, prices: List[int]) -> int:
        """
        贪心思想: 实际是将问题通过画图，简化为求高度差
        """
        if not prices:
            return 0
        max_profit = 0
        for i in range(1, len(prices)):
            max_profit += max(0, prices[i] - prices[i - 1])
        return max_profit