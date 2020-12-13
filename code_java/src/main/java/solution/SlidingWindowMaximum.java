package solution;

import java.util.*;

/**
 * TestCases
 [1,-1] 1
 [7,2,4] 2
 [1,3,1,2,0,5] 3
 */
public class SlidingWindowMaximum {

    /**
     * 注意PriorityQueue的remove复杂度是O(k)，所以本题复杂度是O(n*k)
     * 可以将PriorityQueue转成TreeMap，复杂度为O(n*lgk)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.remove(nums[i - k]);
            }
            if (i - k + 1 >= 0) {
                result[i - k + 1] = queue.peek();
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
