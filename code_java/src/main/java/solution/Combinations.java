package solution;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        combine(n, k, result, path, 1);
        return result;
    }

    private void combine(int n, int k, List<List<Integer>> result, List<Integer> path, int start) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (start > n) {
            return;
        }

        path.add(start);
        combine(n, k - 1, result, path, start + 1);
        path.remove(path.size() - 1);

        combine(n, k, result, path, start + 1);
    }
}
