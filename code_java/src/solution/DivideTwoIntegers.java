package solution;

public class DivideTwoIntegers {

    /**
     * 这题思路是除数不断减去被除数，然后累加1，一直减到除数小于被除数为止
     * 如果被除数很小这样会超时，复杂度为O(n)
     */

    /**
     * 可以进行优化，先减去被除数的1倍，再减去被除数的2倍，再减被除数的4倍，8倍....
     * 直到减不了了，再从头开始，从被除数的1倍开始减
     */
    /**
     * 要注意的地方，一个是溢出，一个是返回结果的符号
     */
    public int divide(int dividend, int divisor) {
        /**
         * 这里都先转成long，以免后面溢出
         */
        long a = dividend >= 0 ? dividend : -1 * (long) dividend;
        long b = divisor >= 0 ? divisor : -1 * (long) divisor;

        long result = 0;

        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; ++i, c <<= 1) {
                a -= c;
                result += 1 << i;
            }
        }
        /**
         * 这里是判断两个数的符号位，如果不一样说明结果为负
         */
        result *= ((dividend ^ divisor) >>> 31) != 0 ? -1 : 1;
        /**
         * 如果溢出则返回整数最大值
         */
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
