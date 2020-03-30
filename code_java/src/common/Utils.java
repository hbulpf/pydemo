public class Utils {

    public static int max(int... val) {
        int max = Integer.MIN_VALUE;
        for (int k : val) {
            max = Math.max(max, k);
        }
        return max;
    }
}
