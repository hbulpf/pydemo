import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    // 耗时4ms
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        dfs(result, n, "", 0, 0);
        return result;
    }

    private void dfs(List<String> result, int n, String str, int left, int right) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left > n || right > n || left < right) {
            return;
        }
        dfs(result, n, str + "(", left + 1, right);
        dfs(result, n, str + ")", left, right + 1);
    }

    // 耗时38ms
    public List<String> generateParenthesis2(int n) {
        List<String>[] f = new LinkedList[n + 1];
        f[0] = new LinkedList<String>(Arrays.asList(""));

        for (int i = 1; i <= n; i++) {
            f[i] = new LinkedList<String>();
            for (int j = 0; j <= i - 1; j++) {
                for (String s1 : f[j]) {
                    for (String s2 : f[i - 1 - j]) {
                        f[i].add(String.format("(%s)%s", s1, s2));
                    }
                }
            }
        }

        return f[n];
    }
}
