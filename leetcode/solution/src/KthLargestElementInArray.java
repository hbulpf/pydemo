import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 注意本题不是返回第k大的distinct number
 */
public class KthLargestElementInArray {

    // 耗时15ms，时间复杂度O(nlgk)，空间复杂度O(k)
    // 按升序排的，出队列k次获取第k大的数
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    // 耗时3ms，时间复杂度O(nlgn)，空间复杂度O(l)
    public int findKthLargest3(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 快速选择，平均时间复杂度为O(n)
    // T(n) = T(n / 2) + n = O(2n)
    // 对比快速排序T(n) = 2T(n / 2) + n = O(nlgn)
    // 区别在于这个被pivot分隔后，只用处理其中的一半，而快排两边都要处理

    /**
     * shuffle非常有必要，性能提升很大
     */
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private void shuffle(int[] nums) {
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = nums.length - 1; i > 1; i--) {
            int index = rnd.nextInt(i + 1);
            swap(nums, index, i);
        }
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);

        int rank = end - pivot + 1;

        if (rank == k) {
            return nums[pivot];
        } else if (rank > k) {
            return findKthLargest(nums, pivot + 1, end, k);
        } else {
            return findKthLargest(nums, start, pivot - 1, k - rank);
        }
    }

    /**
     * 这里两端都是闭区间
     * 这里将数组分为两部分，左边小于pivot，右边大于pivot，中间可能等于pivot
     */
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end], left = start, right = end - 1;

        for (int i = start; i <= right; ) {
            if (nums[i] < pivot) {
                swap(nums, left++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, right--, i);
            } else {
                i++;
            }
        }

        swap(nums, left, end);

        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }
}
