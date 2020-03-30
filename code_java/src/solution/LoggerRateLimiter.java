import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如果要考虑到空间消耗，则要另外定义一个List<String>，每次新来一条日志，都要遍历
 * list中10s外的poll了，同时从map中remove
 *
 */
public class LoggerRateLimiter {

    private HashMap<String, Integer> mMap;

    private Queue<String> mQueue;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        mMap = new HashMap<>();
        mQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int time1 = mMap.getOrDefault(o1, -100);
                int time2 = mMap.getOrDefault(o2, -100);
                return time1 - time2;
            }
        });
    }

    private void clearExpired(int timestamp) {
        while (!mQueue.isEmpty()) {
            String msg = mQueue.peek();
            if (timestamp - mMap.get(msg) >= 10) {
                mQueue.poll();
                mMap.remove(msg);
            } else {
                break;
            }
        }
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = mMap.getOrDefault(message, -100);
        boolean ret = false;
        if (timestamp - time >= 10) {
            mMap.put(message, timestamp);
            ret = true;
        }
        clearExpired(timestamp);
        return ret;
    }
}
