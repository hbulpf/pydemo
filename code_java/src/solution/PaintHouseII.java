package solution;

public class PaintHouseII {

    /**
     * 思路很简单，只要记录上一个house为止的最小cost及index以及次小cost即可
     * 遍历当前house的各种颜色，如果当前颜色和上个house最小cost的颜色不同，则上个house可以取最小cost，否则取次小cost
     */
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int k = costs[0].length;
        int min = 0, minIdx = -1, submin = 0;
        for (int i = 0; i < costs.length; i++) {
            int min0 = Integer.MAX_VALUE, minIdx0 = -1, submin0 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j != minIdx ? min : submin);
                if (cost < min0) {
                    submin0 = min0;
                    min0 = cost;
                    minIdx0 = j;
                } else if (cost < submin0) {
                    submin0 = cost;
                }
            }
            min = min0; minIdx = minIdx0; submin = submin0;
        }
        return min;
    }
}
