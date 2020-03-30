public class Main {

    public static class Solution {

        int reversePairs(int[] arr, int m) {
            int pairs = 0;
            for (int i = m - 1, j = arr.length - 1; j >= m; j--) {
                for ( ; i >= 0 && arr[i] > arr[j]; i--);
                pairs += m - 1 - i;
            }
            return pairs;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {
                1, 4, 8, 9, 2, 3, 6, 7
        };
        int n = s.reversePairs(arr, 4);
        System.out.println(n);
    }
}
