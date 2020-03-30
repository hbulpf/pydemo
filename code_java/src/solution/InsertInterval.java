package solution;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            if (newInterval.start > interval.end) {
                result.add(interval);
            } else if (newInterval.end < interval.start) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        result.add(newInterval);
        return result;
    }
}
