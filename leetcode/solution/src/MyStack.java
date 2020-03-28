import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/articles/implement-stack-using-queues/
 */
public class MyStack {

    private Queue<Integer> mQueue, mQueueTmp;

    public MyStack() {
        mQueue = new LinkedList<Integer>();
        mQueueTmp = new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) {
        mQueue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (!mQueue.isEmpty()) {
            int n = mQueue.poll();
            if (!mQueue.isEmpty()) {
                mQueueTmp.add(n);
            }
        }
        swap();
    }

    private void swap() {
        Queue<Integer> queue = mQueue;
        mQueue = mQueueTmp;
        mQueueTmp = queue;
    }

    // Get the top element.
    public int top() {
        int top = 0;
        while (!mQueue.isEmpty()) {
            top = mQueue.poll();
            mQueueTmp.add(top);
        }
        swap();
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return mQueue.isEmpty();
    }

    /** 这种做法只用一个Queue
    private LinkedList<Integer> q1 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.remove();
    }


    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }*/
}
