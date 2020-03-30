public class SearchInRotatedSortedArrayII {
    /**
     * TestCase
     * [3,1,1], 3
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 注意这里的等号
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);

            if (target == nums[mid]) {
                return mid;
            }

            // 注意这里的等号
            // 先确定单调区间，然后判断target是不是在单调区间内，如果不在就在另一半区间
            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[left]) {
                // nums[mid]==nums[left]有两种情况，在不好确定哪种情况时，left++可以进一步缩小范围
                left++;
            } else {
                // 这里可以肯定nums[mid]<nums[left]，所以mid肯定在拐点右边，换言之右边是单调的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
