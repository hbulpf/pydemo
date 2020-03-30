
public class ReverseInteger {

    // 耗时40ms
    public int reverse2(int x) {
        long y = x, r = 0;
        int sign = x > 0 ? 1 : -1;
        y = y > 0 ? y : -y;
        for ( ; y > 0; y /= 10) {
            r = r * 10 + y % 10;
        }
        r *= sign;
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) r;
    }
}
