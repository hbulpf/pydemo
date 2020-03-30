package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (nums.length == 0) {
            return result;
        }
        /**
         * 千万别掉了排序
         */
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, result, new LinkedList<Integer>());

        return result;
    }

    private void subsetsWithDup(int[] nums, int start, List<List<Integer>> list, List<Integer> path) {
        if (start == nums.length) {
            list.add(new LinkedList<Integer>(path));
            return;
        }

        path.add(nums[start]);
        subsetsWithDup(nums, start + 1, list, path);
        path.remove(path.size() - 1);

        // 既然不带当前字符，那后面如果重复的都别带，否则就是带了当前字符的子集
        for ( ; start + 1 < nums.length && nums[start + 1] == nums[start]; start++);
        subsetsWithDup(nums, start + 1, list, path);
    }
}
