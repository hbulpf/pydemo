package solution;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    /**
     * 仍然采用滑动窗口的办法
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            /**
             * 这里别掉了等号
             */
            if (sum >= s) {
                for (; j < i; j++) {
                    if (sum - nums[j] < s) {
                        break;
                    }
                    sum -= nums[j];
                }
                min = Math.min(min, i - j + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * O(nlgn)的写法
     * sums[0]必须是0，TestCase[1,2,3,4,5],15
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = Arrays.binarySearch(sums, i + 1, sums.length, sums[i] + s);
            end = end < 0 ? -(end + 1) : end;
            if (end == sums.length) {
                break;
            }
            minLen = Math.min(end - i, minLen);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
