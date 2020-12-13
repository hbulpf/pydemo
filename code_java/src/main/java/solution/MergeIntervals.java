package solution;

import common.enties.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/articles/merge-intervals/
 */

public class MergeIntervals {

    // 耗时26ms，时间复杂度O(nlgn)
    public List<Interval> merge(List<Interval> intervals) {
        Interval cur = null;
        List<Interval> result = new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (Interval interval : intervals) {
            if (cur == null) {
                cur = interval;
            } else if (interval.start > cur.end) {
                result.add(cur);
                cur = interval;
            } else {
                cur.end = Math.max(cur.end, interval.end);
            }
        }
        if (cur != null) {
            result.add(cur);
        }
        return result;
    }
}
