package solution;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    // 耗时23ms
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        helper(candidates, result, new LinkedList<>(), target, 0);
        return result;
    }

    private void helper(int[] candidates, List<List<Integer>> result, List<Integer> list, int target, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        } else if (index >= candidates.length) {
            return;
        }

        list.add(candidates[index]);
        helper(candidates, result, list, target - candidates[index], index);
        list.remove(list.size() - 1);

        helper(candidates, result, list, target, index + 1);
    }

    // 耗时22ms
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(candidates, target, 0, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> list) {
        /**
         * target小于0退出的条件千万别掉了,题目给的条件是所有数都为正的
         */
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            /**
             * 注意这里下一个start取i，表示当前数仍可以重复取
             */
            dfs(candidates, target - candidates[i], i, result, list);
            list.remove(list.size() - 1);
        }
    }
}
