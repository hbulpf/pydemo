package solution;

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        int len = s.length();
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            num += (count[i] >> 1) << 1;
        }
        if (num < len) {
            num++;
        }
        return num == len;
    }
}
