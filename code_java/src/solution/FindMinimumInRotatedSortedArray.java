public class FindMinimumInRotatedSortedArray {

    /**
     * 由于[left, right]区间内包含了最小值，nums[left]通常是比nums[right]大的
     * 如果nums[left]<nums[right]只有一个可能，就是nums[left]最小
     *
     * TestCase
     * [1, 2]
     * [2, 1]
     * [1]
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = (left + right) / 2;

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
