package solution;

import common.enties.Interval;

import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {

    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}
