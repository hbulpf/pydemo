/**
 * 如果一个数是另一个数的倍数，那这个数肯定不是素数。
 * 利用这个性质，我们可以建立一个素数数组，从2开始将素数的倍数都标注为不是素数。
 * 第一轮将4、6、8等表为非素数，然后遍历到3，发现3没有被标记为非素数，则将6、9、12等标记为非素数，一直到N为止，
 */
public class CountPrimes {

    // 27ms
    public int countPrimes(int n) {
        boolean[] f = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!f[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    f[i * j] = true;
                }
            }
        }
        return count;
    }
}
