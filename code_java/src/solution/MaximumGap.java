import java.util.Arrays;

public class MaximumGap {

    /**
     * 这题核心是最大gap存在于跨桶的，而不是某个桶内部
     * 首先刨去min和max，剩余n-2个数分散在n-1个桶中，必然导致有的桶里是空的
     * 那么max gap必然是跨桶的
     */
    // 耗时5ms，木桶原理
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        if (min == max) {
            return 0;
        }

        int bucketCount = nums.length - 1;
        int gap = (int) Math.ceil((double) (max - min) / bucketCount);
        int[] mins = new int[bucketCount], maxs = new int[bucketCount];

        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);

        /**
         * 注意区间是左闭右开的，所以max没有包含进来，这里先去掉，最后再算
         * 如果这里不略过max的话，算出来的index会越界
         */
        for (int n : nums) {
            if (n == max) {
                continue;
            }
            int index = (n - min) / gap;
            mins[index] = Math.min(mins[index], n);
            maxs[index] = Math.max(maxs[index], n);
        }

        int last = min, maxGap = 0;
        for (int i = 0; i < bucketCount; i++) {
            // 略过空的桶
            if (mins[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, mins[i] - last);
            last = maxs[i];
        }
        // 最后的max别忘了
        maxGap = Math.max(maxGap, max - last);
        return maxGap;
    }
}
