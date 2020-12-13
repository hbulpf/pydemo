package solution;

import java.util.Arrays;

/**
 * https://leetcode.com/articles/3sum-smaller/
 */
public class ThreeSumSmaller {

    /**
     * 注意这里别画蛇添足的加上
     * if (nums[i] > target) {
     *     break;
     * }
     * 虽然后面的数大于等于nums[i]，但是有可能是负数，三个数之和还是可能小于target的
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] >= target) {
                    k--;
                } else {
                    count += k - j;
                    j++;
                }
            }
        }
        return count;
    }
}
