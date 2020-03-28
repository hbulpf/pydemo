import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    /**
     * 在上面的基础上优化了一下，去掉了一个数组
     */
    public int candy2(int[] ratings) {
        int[] candys = new int[ratings.length];

        Arrays.fill(candys, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        int sum = candys[ratings.length - 1], prev = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            int cur = ratings[i] > ratings[i + 1] ? prev + 1 : 1;
            sum += Math.max(cur, candys[i]);
            prev = cur;
        }
        return sum;
    }
}
