import java.util.Arrays;

/**
 * N株植物，补充1升水
 * 一个数组，N个数字表示int[] {3, 1, 9, 10} ,表示N株的水瓶，选择其中cnt个瓶子,使这些瓶子的水一样多,
 * 两个瓶子水可能一样多，选取的cnt可以不连续,
 * 最少需要多少次?
 * cnt<=N<=10^6
 * 结果对 10^9+7 取模表示结果
 */
public class Main1 {
    public int minOperations(int[] water, int cnt) {
        if (water == null || water.length < 1 || cnt == 0) {
            return 0;
        }
        Arrays.sort(water);
        int len = water.length;
        long minTimes = Integer.MAX_VALUE;
        for (int i = 0; i <= len - cnt; i++) {
            long tmp = 0;
            for (int j = 0; j < cnt - 1; j++) {
                tmp += water[i + cnt - 1] - water[i + j];
            }
            if (minTimes > tmp) {
                minTimes = tmp;
            }
        }
        return (int) (minTimes % (int) (Math.pow(10, 9) + 7));
    }
}
