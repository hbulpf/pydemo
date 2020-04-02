package solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 可以轻易拓展到k的情况
 */
public class ZigzagIterator {

    private List<Iterator<Integer>> mIterators = new ArrayList<>();

    private int mIndex;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        init(v1, v2);
    }

    private void init(List<Integer>... lists) {
        for (List<Integer> list : lists) {
            if (!list.isEmpty()) {
                mIterators.add(list.iterator());
            }
        }
    }

    public int next() {
        mIndex %= mIterators.size();
        Iterator<Integer> iterator = mIterators.get(mIndex);
        int n = iterator.next();
        if (!iterator.hasNext()) {
            mIterators.remove(iterator);
        } else {
            mIndex++;
        }
        return n;
    }

    public boolean hasNext() {
        return !mIterators.isEmpty();
    }
}
