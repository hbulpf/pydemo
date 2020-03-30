import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {

    // 耗时29ms，时间复杂度O(n)
    public int maxSubArrayLen2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        map.put(0, -1);

        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            int idx = map.getOrDefault(sum - k, -2);
            if (idx >= -1 && i - idx > maxLen) {
                maxLen = i - idx;
            }
        }

        return maxLen;
    }
}
