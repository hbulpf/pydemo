package solution;

import common.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/articles/meeting-rooms/
 */
public class MeetingRooms {

    // 时间复杂度O(nlgn)
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start > o2.start ? 1 : -1;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }
}
