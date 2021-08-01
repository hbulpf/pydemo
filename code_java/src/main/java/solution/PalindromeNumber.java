package solution;

public class PalindromeNumber {

    // 耗时101ms
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int y = 1;
        for ( ; y <= x / 10; y *= 10);

        for (int t = 1; t < y; t *= 10, y /= 10) {
            if ((x / y) % 10 != (x / t) % 10) {
                return false;
            }
        }

        return true;
    }

    /**
     * 直接给数倒过来看是否相等
     * 耗时103ms
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int n = 0, m = x;
        for ( ; x > 0; x /= 10) {
            n = n * 10 + x % 10;
        }
        return n == m;
    }
}
