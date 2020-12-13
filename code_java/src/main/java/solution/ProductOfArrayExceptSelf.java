package solution;

public class ProductOfArrayExceptSelf {

    // 耗时1ms
    /**
     * 对于每个数，就是给其左边所有数乘一遍，再给其右边所有数乘一遍
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
