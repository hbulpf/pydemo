package solution;

import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(n, 2, result, new LinkedList<>());
        return result;
    }

    private void dfs(int n, int cur, List<List<Integer>> result, List<Integer> list) {
        if (n <= 1) {
            if (list.size() > 1) {
                result.add(new LinkedList<>(list));
            }
            return;
        }

        for (int i = cur; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(n / i, i, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
