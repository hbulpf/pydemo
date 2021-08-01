package solution;

import java.util.Arrays;

public class TaskScheduler {

    /**
     * 这题关键是先按频率排序，最高频的优先占座，中间隔着stub，然后依次插次低频的
     * 有两种情况，
     * 一种是stub不够用，元素不但给stub替换完了，还要多塞元素，如AAAABBBBCCCCDDDD, n=2，这种情况结果是tasks.length
     * 第二种是stub太多了，元素替换不完，中间留了不少空，如AABB, n=3，这种情况结果是(count[25] - 1) * n + count[25] + 24 - i
     * 这里(count[25] - 1) * n是插入的stub总数，24 - i是除了count[25]外和count[25]同样频率的数的个数
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int i = 25;
        for (; i >= 0 && count[i] == count[25]; i--) ;
        // (count[25] - 1) * n + count[25] + 24 - i = (count[25] - 1) * (n + 1) + 25 - i
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }
}
