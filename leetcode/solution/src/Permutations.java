import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(nums, result, 0);
        return result;
    }

    public void permute(int[] nums, List<List<Integer>> result, int start) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (Integer n : nums) {
                list.add(n);
            }
            result.add(list);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, result, start + 1);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
