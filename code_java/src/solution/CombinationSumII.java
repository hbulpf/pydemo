import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

    // 耗时29ms
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
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
        helper(candidates, result, list, target - candidates[index], index + 1);
        list.remove(list.size() - 1);

        for ( ; index < candidates.length - 1 && candidates[index + 1] == candidates[index]; index++);

        helper(candidates, result, list, target, index + 1);
    }

    /**
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> path) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);

            // 关键是这里变成i + 1
            dfs(candidates, i + 1, target - candidates[i], result, path);
            path.remove(path.size() - 1);
        }
    }*/
}
