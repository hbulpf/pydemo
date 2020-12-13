package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * 关键公式整数n的格雷码为n ^ (n / 2)
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<Integer>();
        int target = 1 << n;
        for (int i = 0; i < target; i++) {
            list.add(i ^ (i >>> 1));
        }
        return list;
    }
}
