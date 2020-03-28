public class MaximumProductSubarray {

    /**
     * 这题很容易错的地方在于要同时记住最大值和最小值，因为可能有负数，
     * 最小的负数乘以负数可能会变成最大的正直
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE, max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = min = nums[i];
            } else {
                /**
                 * 这里一定要先给之前的值记下来，不然在算min时用到的max已经是当前改过的了
                 */
                int prevMax = max, prevMin = min;
                max = Math.max(nums[i], Math.max(nums[i] * prevMax, nums[i] * prevMin));
                min = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * prevMin));
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
