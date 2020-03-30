public class BulbSwitcher {
    /**
     * https://discuss.leetcode.com/topic/39558/share-my-o-1-solution-with-explanation/2
     * 思路就是对于一个数k，其约数因子都是成对出现的，除非k是平方数。
     * 如k=12,其约数为1,2,3,4,6,12，都是成对出现的，所以最后开关状态都抵消了
     * 但是对于k=16,其约数为1,2,4,8,16，平方数就不是成对的了，所以最后开关没全抵消，所以灯就是ON
     * 这道题就是找在n范围内一共有多少个平方数
      */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    // 这种解法很直观，但是显然会超时
    public int bulbSwitch2(int n) {
        if (n == 0) {
            return 0;
        }

        boolean[] flag = new boolean[n];

        int ons = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                flag[j] = !flag[j];
                ons += flag[j] ? 1 : -1;
            }
        }

        return ons;
    }
}
