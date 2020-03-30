/**
 * 这题注意边界情况
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        long first = (long) Integer.MIN_VALUE - 1;
        long second = first, third = first;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first || nums[i] == second || nums[i] == third) {
                continue;
            }
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        return (int) (third >= Integer.MIN_VALUE ? third : first);
    }
}
