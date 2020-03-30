public class CountReversePairs {

    /**
     * 数组arr，[0,m)和[m,arr.length)两个区间都是递增的
     * 如果[0,m)区间的数比[m, arr.len)区间大，则能构成一个reverse pair
     * 问有多少个reverse pair
     */
    int reversePairs(int[] arr, int m) {
        int pairs = 0;
        for (int i = m - 1, j = arr.length - 1; j >= m; j--) {
            for ( ; i >= 0 && arr[i] > arr[j]; i--);
            pairs += m - 1 - i;
        }
        return pairs;
    }
}

