package solution;

// 是longest increasing subsequence的简化版
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            /**
             * 这里的条件都要带等号
             */
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}
