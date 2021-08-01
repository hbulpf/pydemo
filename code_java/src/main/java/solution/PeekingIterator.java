package solution;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> mIterator;

    private Integer mNext;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        mIterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (mNext != null) {
            return mNext;
        }
        mNext = mIterator.next();
        return mNext;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (mNext != null) {
            Integer ret = mNext;
            mNext = null;
            return ret;
        }
        return mIterator.next();
    }

    @Override
    public boolean hasNext() {
        return mNext != null || mIterator.hasNext();
    }
}
