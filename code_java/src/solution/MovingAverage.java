package solution;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {

    private int mSize;

    private double mSum;
    private Deque<Integer> mQueue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        mSize = size;
    }

    public double next(int val) {
        mQueue.offerLast(val);
        mSum += val;
        if (mQueue.size() > mSize) {
            mSum -= mQueue.pollFirst();
        }
        return mSum / mQueue.size();
    }
}
