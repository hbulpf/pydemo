package solution;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int len = s.length();

        int CHAR_MAX = 256;
        int[] f = new int[CHAR_MAX];

        for (int i = 0; i < len; i++) {
            f[s.charAt(i)]++;
        }

        int count = 0;
        for (int i = 0; i < CHAR_MAX; i++) {
            count += ((f[i] >> 1) << 1);
        }

        if (count < len) {
            count++;
        }

        return count;
    }
}
