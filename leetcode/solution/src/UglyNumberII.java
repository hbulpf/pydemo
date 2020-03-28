public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] f = new int[n];
        f[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < n; i++) {
            f[i] = Math.min(Math.min(f[t2] * 2, f[t3] * 3), f[t5] * 5);

            if(f[i] >= f[t2] * 2) {
                t2++;
            }
            if(f[i] >= f[t3] * 3) {
                t3++;
            }
            if(f[i] >= f[t5] * 5) {
                t5++;
            }
        }
        return f[n - 1];
    }
}
