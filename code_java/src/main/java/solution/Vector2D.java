package solution;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    private Iterator<List<Integer>> mIterator;
    private Iterator<Integer> mSubIterator;

    public Vector2D(List<List<Integer>> vec2d) {
        mIterator = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return mSubIterator.next();
        }
        return 0;
    }

    @Override
    public boolean hasNext() {
        while (mSubIterator == null || !mSubIterator.hasNext()) {
            if (mIterator.hasNext()) {
                mSubIterator = mIterator.next().iterator();
            } else {
                break;
            }
        }
        return mSubIterator != null && mSubIterator.hasNext();
    }
}
