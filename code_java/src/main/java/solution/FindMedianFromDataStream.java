package solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    /**
     * 比较大的一半
     */
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();

    /**
     * 比较小的一半
     */
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Comparator.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());

        /**
         * 要保证比较大的一半的size大于等于小的一半
         */
        if(maxheap.size() < minheap.size()){
            maxheap.offer(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return maxheap.size() == minheap.size() ? (double)(maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }
}
