package solution;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] fac = new int[n + 1];
        fac[0] = 1;

        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i;
            list.add(i);
        }

        k--;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int ind = k / fac[n - i];
            k %= fac[n - i];
            sb.append(list.remove(ind));
        }

        return sb.toString();
    }
}
