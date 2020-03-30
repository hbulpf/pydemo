public class SearchForARange {

    /**
     * TestCase
     * [1], 0
     * [1], 1
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = firstHigherEqual(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[] {
                    -1, -1
            };
        }
        return new int[] {
                first,
                firstHigherEqual(nums, target + 1) - 1
        };
    }

    // 测区间只有1个数或两个数的情况
    private int firstHigherEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
