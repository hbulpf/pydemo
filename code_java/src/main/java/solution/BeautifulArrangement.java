package solution;

/**
 * https://leetcode.com/articles/beautiful-arrangement/
 */
public class BeautifulArrangement {

    public int countArrangement(int N) {
        int[] count = new int[1];
        helper(N, 1, new boolean[N + 1], count);
        return count[0];
    }

    private void helper(int N, int k, boolean[] visited, int[] count) {
        if (k > N) {
            count[0]++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (i % k == 0 || k % i == 0)) {
                visited[i] = true;
                helper(N, k + 1, visited, count);
                visited[i] = false;
            }
        }
    }
}
