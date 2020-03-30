/**
 * https://leetcode.com/articles/remove-duplicates-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (j == -1 || nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
