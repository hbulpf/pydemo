package solution;

import java.util.HashMap;

/**
 * https://leetcode.com/articles/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    /**
     * map中保存的是某个点所在的联通块长度，不过要注意的这个连通块两端的点才是准的，中间的点可能不准
     * 所以我们每次新插入一个点时，一定要更新连通块两端的点
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int len = left + right + 1;
                map.put(n, len);
                map.put(n - left, len);
                map.put(n + right, len);
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}
