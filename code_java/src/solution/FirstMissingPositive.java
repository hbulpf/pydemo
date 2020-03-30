/**
 * 这里要注意的是nums[nums[i] - 1] != nums[i]这个条件，意思是目标坑和当前坑的值不等，此时才能swap
 * 倘若换成nums[i] - 1 != i是不行的，这表示目标坑和当前坑不是一个坑就swap，会死循环
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
