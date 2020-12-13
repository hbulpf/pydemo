package solution;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/articles/sliding-window-median/
 * 和 #295 Find Median from Data Stream 比较类似
 */

public class SlidingWindowMedian {

    /**
     * 这题如果用PriorityQueue则复杂度为O(nk)，因为其删除复杂度为O(n)
     * 改为TreeMap会降为O(nlgk)
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        MyMap up = new MyMap();
        MyMap down = new MyMap(Comparator.reverseOrder());
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            up.myAdd(nums[i]);
            down.myAdd(up.myPollFirst());

            if (i >= k) {
                if (up.containsKey(nums[i - k])) {
                    up.myRemove(nums[i - k]);
                } else {
                    down.myRemove(nums[i - k]);
                }
            }

            if (up.size < down.size) {
                up.myAdd(down.myPollFirst());
            }
            if (i >= k - 1) {
                result[i - k + 1] = up.size == down.size
                        ? ((double) up.firstKey() + down.firstKey()) / 2 : up.firstKey();
            }
        }
        return result;
    }

    class MyMap extends TreeMap<Integer, Integer> {
        int size;

        MyMap() {
            super();
        }

        MyMap(Comparator<Integer> comparator) {
            super(comparator);
        }

        void myAdd(int n) {
            put(n, getOrDefault(n, 0) + 1);
            size++;
        }

        boolean myRemove(int n) {
            int count = getOrDefault(n, 0);
            if (count == 0) {
                return false;
            }
            if (count == 1) {
                remove(n);
            } else {
                put(n, count - 1);
            }
            size--;
            return true;
        }

        int myPollFirst() {
            Map.Entry<Integer, Integer> entry = firstEntry();
            if (entry.getValue() == 1) {
                pollFirstEntry();
            } else {
                put(entry.getKey(), entry.getValue() - 1);
            }
            size--;
            return entry.getKey();
        }
    }
}
