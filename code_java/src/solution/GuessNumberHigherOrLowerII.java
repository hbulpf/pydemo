/**
 * 可参考官方文档
 * https://leetcode.com/articles/guess-number-higher-or-lower-ii/
 * 这题不能用二分法做了，是从最差情况中挑最好的值
 */
public class GuessNumberHigherOrLowerII {
    /**
     * 在[start,end]中首先挑i，最差情况是i是错的，那么cost要加i，然后再从[start,i-1]和[i+1,end]中继续挑，由于是最差情况，
     * 所以我们假定每次都是错的，所以cost(start,end)=i+max(cost(start,i-1),cost(i+1,end))，i在[start,end]之间遍历，从所有
     * 最差情况中找到一个最小值，这就是我们要首先猜的那个数了。
     */

    /**
    public int getMoneyAmount(int n) {
        return getMoneyAmount(1, n);
    }

    // 暴力方法，时间复杂度O(n!), 空间复杂度O(n)
    private int getMoneyAmount(int start, int end) {
        if (start >= end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int res = i + Math.max(getMoneyAmount(start, i - 1), getMoneyAmount(i + 1, end));
            min = Math.min(min, res);
        }
        return min;
    }*/

    /**
    // 耗时18ms，和上面思路一样，只是用了缓存，避免重复计算
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return getMoneyAmount(dp, 1, n);
    }

    private int getMoneyAmount(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int res = i + Math.max(getMoneyAmount(dp, start, i - 1), getMoneyAmount(dp, i + 1, end));
            min = Math.min(min, res);
        }
        dp[start][end] = min;
        return min;
    }*/

    // 注意这里len要从2开始，耗时15ms
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {

            for (int start = 1; start + len - 1 <= n; start++) {
                int minRes = Integer.MAX_VALUE;

                // 注意这里pivot的边界，因为下面有pivot+1可能越界
                for (int pivot = start; pivot < start + len - 1; pivot++) {
                    int res = pivot + Math.max(dp[start][pivot - 1], dp[pivot + 1][start + len - 1]);
                    minRes = Math.min(res, minRes);
                }

                dp[start][start + len - 1] = minRes;
            }
        }
        return dp[1][n];
    }

    /**
     * 还有一点优化，不过我没想太明白，就是选择pivot时，以(start+end)/2为起点，而不是从start，大致原因是
     * 相同长度下，数字越小的序列试错成本越低，所以以左边为轴的试错成本肯定高于以右边为轴的成本。
     */
}

