package solution;

public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * 思路跟Longest Substring With At Most Two Distinct Characters一样，只是给2改成k，要注意k等于0时返回0
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longest = 0;
        int[] dp = new int[256];
        for (int i = 0, j = 0, n = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (dp[c]++ == 0) {
                for (++n; i <= j && n > k; i++) {
                    if (--dp[s.charAt(i)] == 0) {
                        n--;
                    }
                }
            }
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }

}
