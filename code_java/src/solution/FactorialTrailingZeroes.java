public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int sum;
        for (sum = 0; n > 0; n /= 5, sum += n);
        return sum;
    }
}
