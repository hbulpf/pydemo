package solution;

import java.util.Arrays;

/**
 * TestCase
 * [1,2,2,1,2,1,1,1,1,2,2,2]
 */
public class WiggleSortII {

    // 时间复杂度O(nlgn)，空间复杂度O(n)
    // 先排序，然后从中间分成两半，先取前面一半的末尾，再取后半的末尾，再取前半的倒数第二个，再取后半倒数第二个，依次类似
    // 注意当个数为奇数时，中间那个要分到前面一半中
    public void wiggleSort2(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length, j = (n - 1) / 2, k = n - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? arr[j--] : arr[k--];
        }
    }

    /**
     * 这个解法的核心思想如下：
     * 用partition法将数组分为三波，左边一波为大于median的记为L，中间一波为median记为M，右边一波为小于median的记为S，每一波内顺序都无所谓
     * 将L从左到右依次放在奇数位上，将S从右到左依次放在偶数位上，多余的空填M。
     * 最终结果类似如下：
     * M L S L S M
     * M L S L S
     * 只要这样交叉放着就能符合wiggle
     * 直观的做法是另外开辟一个空间来放wiggle结果
     * 如果要求不开辟空间，则只能用坐标映射了
     * 类似的可以参考sort colors和find kth largest element
     */
    // 时间复杂度O(n)，空间复杂度O(l)
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int median = findKthLargest(nums, (len + 1) / 2);
        for (int left = 0, right = len - 1, i = 0; i <= right; ) {
            if (nums[newIndex(i, len)] > median) {
                swap(nums, newIndex(left++, len), newIndex(i++, len));
            } else if (nums[newIndex(i, len)] < median) {
                swap(nums, newIndex(right--, len), newIndex(i, len));
            } else {
                i++;
            }
        }
    }

    /**
     * 将数组分为两半，后面一半的个数大于等于前面的一半
     * 先取后面一半的第一个，再取前面一半的第一个
     * 再取后面一半的第二个，再取前面一半的第二个
     * 依次类推，得到一个映射关系
     */
    private int newIndex(int index, int n) {
        int ret = (1 + 2 * index) % (n | 1);
//        System.out.println(String.format("newIndex for %d, %d = %d", index, n, ret));
        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest(int[] nums, int k) {
        return nums[findKthLargest(nums, 0, nums.length - 1, k)];
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);

        int rank = end - pivot + 1;

        if (rank == k) {
            return pivot;
        } else if (rank > k) {
            return findKthLargest(nums, pivot + 1, end, k);
        } else {
            return findKthLargest(nums, start, pivot - 1, k - rank);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end], left = start;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, left++, i);
            }
        }

        swap(nums, left, end);

        return left;
    }
}
