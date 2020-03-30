public class LongestSubstringWithAtMostTwoDistinctCharacters {

    // 1ms
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[256];
        int count = 0, longest = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (dp[s.charAt(j)]++ == 0) {
                for (++count; i <= j && count > 2; ) {
                    if (--dp[s.charAt(i++)] == 0) {
                        --count;
                    }
                }
            }
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
}
