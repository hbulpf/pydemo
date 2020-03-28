import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE, res = 0;
        for (int k = 0; k < nums.length - 2; k++) {

            for (int i = k + 1, j = nums.length - 1; i < j; ) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    return sum;
                }
                int delta = Math.abs(sum - target);
                if (delta < min) {
                    min = delta;
                    res = sum;
                }
            }
        }
        return res;
    }
}
