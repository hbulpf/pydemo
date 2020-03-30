package solution;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1, k = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (j < 0) {
                nums1[i] = nums2[k--];
            } else if (k < 0) {
                nums1[i] = nums1[j--];
            } else {
                if (nums1[j] >= nums2[k]) {
                    nums1[i] = nums1[j--];
                } else {
                    nums1[i] = nums2[k--];
                }
            }
        }
    }
}
