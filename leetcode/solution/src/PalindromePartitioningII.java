public class PalindromePartitioningII {

    /**
     * 这里cuts[0]=-1是为了兼容j=i=0的情况
     */
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n + 1];
        cuts[0] = -1;
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int cut = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (j > i - 2 || f[j + 1][i - 1])) {
                    f[j][i] = true;
                    cut = Math.min(cut, cuts[j] + 1);
                }
            }
            cuts[i + 1] = cut;
        }
        return cuts[n];
    }
}
