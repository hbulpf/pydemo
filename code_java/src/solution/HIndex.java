import java.util.Arrays;

/**
 * https://leetcode.com/articles/h-index/
 */

/**
 * TestCase
 * [0]
 * [1]
 * []
 * [100]
 */
public class HIndex {

    // 耗时4ms，时间复杂度O(nlgn)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            hIndex = Math.max(hIndex, Math.min(citations.length - i, citations[i]));
        }
        return hIndex;
    }

    // 耗时1ms，时间复杂度O(n)
    public int hIndex2(int[] citations) {
        /**
         * 大于文章数的引用可以合并到一起
         */
        int n = citations.length;
        int[] f = new int[n + 1];
        for (int k : citations) {
            f[Math.min(k, n)]++;
        }
        int hindex = 0;
        /**
         * i表示引用数，j表示大于等于该引用数的总文章数
         */
        for (int i = n, j = 0; i >= 0; i--) {
            j += f[i];
            hindex = Math.max(hindex, Math.min(j, i));
        }
        return hindex;
    }
}
