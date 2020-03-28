public class Pow {

    /**
     * 这道题要注意的有几点：
     * 1. n为0的情况
     * 2. n为负数的情况，要给n变为正，同时x取倒
     * 3. n由负变正可能会溢出，所以要改成long
     */
    public double myPow(double x, int n) {
        return helper(x, n);
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return helper(1 / x, -n);
        }
        double y = helper(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
