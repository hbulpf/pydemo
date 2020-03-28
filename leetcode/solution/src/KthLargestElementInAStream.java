import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

    class KthLargest {

        Queue<Integer> queue = new PriorityQueue<>();
        int capacity;

        public KthLargest(int k, int[] nums) {
            capacity = k;
            for (int n : nums) {
                queue.offer(n);
            }
        }

        public int add(int val) {
            queue.offer(val);
            while (queue.size() > capacity) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
