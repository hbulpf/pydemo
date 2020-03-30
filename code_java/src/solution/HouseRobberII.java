public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }
        // 包含第一个就不能包含最后一个，包含最后一个就不能包含第一个
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int prev = 0, cur = 0;
        for (int i = start; i <= end; i++) {
            int temp = cur;
            cur = Math.max(nums[i] + prev, cur);
            prev = temp;
        }
        return cur;
    }
}
