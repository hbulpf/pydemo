import java.util.TreeSet;

/**
 * 这题意思是第i盆花第flowers[i]天开，问第几天的时候存在这么一种情况：有两盆已经开的花中间恰好隔着k盆没开的花
 */
public class KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> map = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int flower = flowers[i] - 1;
            map.add(flower);

            Integer key = map.ceiling(flower + 1);
            if (key != null && key - flower == k + 1) {
                return i + 1;
            }
            key = map.floor(flower - 1);
            if (key != null && flower - key == k + 1) {
                return i + 1;
            }
        }

        return -1;
    }

    /**
     * 时间复杂度O(n)
     * days表示第i盆花第几天开
     * 天数越大，表示花开的越晚
     * 对于(left, right)这个区间，(这个区间刚好相隔k)，如果days值都比left和right大，说明(left,right)区间的花都开的比left和right晚
     * 换言之，在left和right开的时候，中间的花都没开，而left和right刚好相隔k，符合条件。
     * 我们选择left和right之中较大的那个值作为备选结果之一，选取较大是因为表示发生的较晚，刚好触发条件
     * 但是题目要返回最早的那一天，所以我们要继续遍历下去
     *
     * 此外还要注意，当发现(left,right)区间存在不符合条件的情况，则sliding window要从i开始，因为如果从(left,i)区间的任何一个数开始，都不会符合条件
     * 另外当找到一组符合条件的情况后，sliding window也要从i开始，也就是从right开始，假如从left+1开始，则当前的right就不符合大于sliding window两端的条件了
     */
    public int kEmptySlots2(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for (int i = left + 1; i <= right && right < days.length; i++) {
            if (i == right) {
                res = Math.min(res, Math.max(days[left], days[right]));
                left = i;
                right = k + 1 + i;
                continue;
            }

            if (days[i] < days[left] || days[i] < days[right]) {
                left = i;
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
