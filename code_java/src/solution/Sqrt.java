package solution;

public class Sqrt {

    /**
     * 这题容易错的有两点：
     * 1. 不能用mid * mid，可能会溢出，需要用x / mid
     * 2. 临界点的情况，即mid < m的情况，此时结果可能等于mid，也可能更大，l = mid是没问题的，只是我们要考虑只剩两个数的
     * 情形，因为会死循环。假设最后两个数是a和b，假设mid为a时mid<m，则l=mid+1，这样做是为了验证b，如果b的时候mid大于m了，
     * 则r=mid-1会返回a。如果b的时候mid小于m，则l=mid+1会超出范围，最后还是返回l-1
     */
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int m = x / mid;

            if (mid == m) {
                return mid;
            } else if (mid > m) {
                r = mid - 1;
            } else if (mid < m) {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
