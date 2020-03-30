package solution;

/**
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
            for ( ; j < i && count[c] > 1; j++) {
                count[s.charAt(j)]--;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
