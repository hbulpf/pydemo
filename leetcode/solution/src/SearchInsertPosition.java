import java.util.Arrays;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, 0, nums.length, target);
        return index >= 0 ? index : -(index + 1);
    }
}
