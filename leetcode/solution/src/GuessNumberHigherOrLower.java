/**
 * 可参考官方文档
 * https://leetcode.com/articles/guess-number-higher-or-lower/
 */
public abstract class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + ((right - left) >>> 1);

            int guess = guess(mid);

            if (guess > 0) {
                left = mid + 1;
            } else if (guess < 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    abstract int guess(int num);
}

