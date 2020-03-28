public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[left] < nums[right]) {
                return nums[left];
            }

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                /**
                 * 这里表示mid不在左单调区间，也不在右单调区间，有两种情况
                 * 1，nums[mid] == nums[left]，此时最小值肯定在left右边，有可能在mid左边，也可能在mid右边
                 * 2，nums[mid] == nums[right]，此时最小值肯定在left右边，但可能在mid右边，也可能在mid左边
                 * 综上，肯定在left右边
                 */
                left++;
            }
        }

        return nums[left];
    }
}
