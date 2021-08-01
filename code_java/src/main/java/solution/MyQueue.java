package solution;

import java.util.Stack;

/**
 * https://leetcode.com/articles/implement-queue-using-stacks/
 */
public class MyQueue {

    private Stack<Integer> mStack = new Stack<Integer>();
    private Stack<Integer> mStackTmp = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        mStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        dump(mStack, mStackTmp);
        mStackTmp.pop();
        dump(mStackTmp, mStack);
    }

    // Get the front element.
    public int peek() {
        dump(mStack, mStackTmp);
        int peek = mStackTmp.peek();
        dump(mStackTmp, mStack);
        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return mStack.isEmpty();
    }

    private void dump(Stack<Integer> left, Stack<Integer> right) {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
    }
}
