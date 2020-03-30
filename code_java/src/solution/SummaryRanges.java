package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/articles/summary-ranges/
 * 和 163. Missing Ranges 比较类似
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int start = nums[0], to = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == to + 1) {
                to++;
            } else {
                list.add(getRange(start, to));
                start = to = nums[i];
            }
        }
        list.add(getRange(start, to));
        return list;
    }

    private String getRange(int start, int to) {
        return to > start ? start + "->" + to : String.valueOf(to);
    }
}
