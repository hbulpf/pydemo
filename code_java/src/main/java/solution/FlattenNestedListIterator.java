package solution;

import common.enties.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public abstract class FlattenNestedListIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        push(nestedList);
    }

    private void push(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger nest = nestedList.get(i);
            if (nest.isInteger()) {
                stack.push(nest);
            } else {
                push(nest.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
