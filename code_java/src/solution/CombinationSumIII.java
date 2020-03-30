package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * 这题不允许重复数字
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        helper(k, n, result, new LinkedList<>(), 1);
        return result;
    }

    private void helper(int k, int n, List<List<Integer>> result, List<Integer> list, int cur) {
        if (n == 0 && k == 0) {
            result.add(new LinkedList<>(list));
            return;
        }

        if (cur > 9) {
            return;
        }

        list.add(cur);
        helper(k - 1, n - cur, result, list, cur + 1);
        list.remove(list.size() - 1);

        helper(k, n, result, list, cur + 1);
    }

    /**
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(n, k, 1, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int target, int k, int start, List<List<Integer>> result, List<Integer> list) {
        if (target == 0 && k == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (target <= 0 || k <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(target - i, k - 1, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }*/
}
