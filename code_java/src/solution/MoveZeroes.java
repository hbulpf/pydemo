/**
 * https://leetcode.com/articles/move-zeroes/
 */
public class MoveZeroes {

    /**
     * 要保持顺序
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for ( ; j < nums.length; nums[j++] = 0);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * 如果不要求保持顺序，且写的次数最少
     * 从两头开始往中间走，如果左边是0，右边非0，则交换，写的次数是0的个数乘2
     */
    public void moveZeroes2(int[] nums) {
        for (int i = 0, j = nums.length - 1; j > i; ) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[j] != 0) {
                swap(nums, i, j--);
            } else {
                j--;
            }
        }
    }
}
