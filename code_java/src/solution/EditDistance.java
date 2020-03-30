/**
 * 这题非常重要的是对f的初始化，千万不能漏
 * 所有DP问题都要注意初始化边界条件
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            f[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    int min = Math.min(f[i][j - 1], f[i - 1][j]);
                    f[i][j] = Math.min(f[i - 1][j - 1], min) + 1; /** 这里的加1别掉了 */
                }
            }
        }
        return f[len1][len2];
    }
}
