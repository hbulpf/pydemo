package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路是对每个index，有两种情况，要还是不要
 * 要注意的是添加结果到result时，要复制一个列表，别直接加list
 */
public class Subsets {

    /**
     * 时间复杂度O(2^n)，空间复杂度 O(n)
     */

    /**
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (nums.length == 0) {
            return result;
        }

        subsets(nums, 0, result, new LinkedList<Integer>());

        return result;
    }

    private void subsets(int[] nums, int start, List<List<Integer>> list, List<Integer> path) {
        if (start == nums.length) {
            list.add(new LinkedList<Integer>(path));
            return;
        }

        path.add(nums[start]);
        subsets(nums, start + 1, list, path);
        path.remove(path.size() - 1);

        subsets(nums, start + 1, list, path);
    }
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        subsets(nums, 0, result, new LinkedList<Integer>());
        return result;
    }

    private void subsets(int[] nums, int start, List<List<Integer>> result, List<Integer> path) {
        result.add(new LinkedList<Integer>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            subsets(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
