package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * TestCases
 * [], lower=1, upper=1
 * [2147483647], lower=0,upper=2147483647
 * 注意溢出的问题
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new LinkedList<String>();
        long next = lower;
        for (int n : nums) {
            if (n < next) {
                continue;
            }
            if (n > next) {
                list.add(getRange(next, n - 1));
            }
            next = (long) n + 1;
        }
        if (upper >= next) {
            list.add(getRange(next, upper));
        }
        return list;
    }

    private String getRange(long start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
