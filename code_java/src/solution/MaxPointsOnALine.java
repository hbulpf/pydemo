package solution;

import java.awt.*;
import java.util.HashMap;

/**
 * TestCase
 * 边界条件很多，比如有重复的点，有斜率无穷大的线
 * [[3,10],[0,2],[0,2],[3,10]] result = 4
 * [[2,3],[3,3],[-5,3]] result = 3
 */
public class MaxPointsOnALine {

    /**
     * 起点固定时，斜率相同，则肯定在一条直线上
     */
    // 耗时22ms
    public int maxPoints2(Point[] points) {
        if (points.length <= 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        HashMap<Double, Integer> map = new HashMap<Double, Integer>();

        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            map.clear();

            int samep = 1, max = 0;

            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j].x - points[i].x;
                int deltaY = points[j].y - points[i].y;

                if (deltaX == 0 && deltaY == 0) {
                    samep++;
                    continue;
                }

                // 注意算斜率时可能出现k=0.0和-0.0的现象，两个是不一样的，所以这里对deltaY特殊处理
                double k = deltaX == 0 ? Double.MAX_VALUE : deltaY == 0 ? 0 : (double) deltaY / deltaX;

                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 1);
                }

                max = Math.max(max, map.get(k));
            }

            result = Math.max(result, max + samep);
        }

        return result;
    }
}
