import java.util.Arrays;

/**
 * https://leetcode.com/articles/valid-anagram/
 */
public class ValidAnagram {

    // 耗时6ms，时间复杂度O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 耗时6ms，时间复杂度O(nlgn)
    public boolean isAnagram2(String s, String t) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        char[] tt = t.toCharArray();
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }
}
