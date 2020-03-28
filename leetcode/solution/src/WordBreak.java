import java.util.List;

/**
 * https://leetcode.com/articles/word-break/
 */
public class WordBreak {

    // 耗时3ms
    // 典型的DP问题
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int j = i - word.length();
                if (j >= 0 && dp[j] && s.substring(j, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
