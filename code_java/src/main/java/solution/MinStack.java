package solution;

import java.util.Stack;

public class MinStack {

    Stack<Integer> mMinStack;

    Stack<Integer> mStack;

    public MinStack() {
        mStack = new Stack<Integer>();
        mMinStack = new Stack<Integer>();
    }

    public void push(int x) {
        mStack.push(x);

        // 注意这里要判空
        if (mMinStack.isEmpty() || x < mMinStack.peek()) {
            mMinStack.push(x);
        } else {
            mMinStack.push(mMinStack.peek());
        }
    }

    public void pop() {
        mStack.pop();
        mMinStack.pop();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return mMinStack.peek();
    }
}
