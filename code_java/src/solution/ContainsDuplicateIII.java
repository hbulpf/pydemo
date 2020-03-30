import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/articles/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {

    /**
     * 这题要注意溢出问题，干脆都用long
     * 时间复杂度O(nlg(min(n,k))
     * 这里相当于维护了一个window，每次新遍历到一个数，都查看上下相邻的数是否满足条件
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            long n = nums[i];
            Long s = set.ceiling(n);
            if (s != null && s <= n + t) return true;

            Long g = set.floor(n);
            if (g != null && n <= g + t) return true;

            set.add(n);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 这题关键要注意溢出的问题
     * TestCase
     * [-1, 2147483647], k = 1, t = 2147483647
     */
    /**
     * 本来bucket size应该为t的，但是考虑到t=0的case，所以还是取t+1吧.
     */

    private long getBucketId(long val, long bucketSize) {
        return (val - Integer.MIN_VALUE) / (bucketSize);
    }

    /**
     * 这里一个桶里肯定不会同时有多个数，否则直接就返回了
     * 所以不用考虑map覆盖的问题
     */
    //[s,s+t+1), [s+t+1,s+2t+2), [s+2t+2,s+3t+3), [s+3t+3,s+4t+4)...
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long index = getBucketId(nums[i], (long) t + 1);

            if (map.containsKey(index)) {
                return true;
            }

            if (map.containsKey(index - 1) && (long) nums[i] - map.get(index - 1) <= t) {
                return true;
            }

            if (map.containsKey(index + 1) && map.get(index + 1) - (long) nums[i] <= t) {
                return true;
            }

            map.put(index, (long) nums[i]);

            if (i >= k) {
                index = getBucketId(nums[i - k], (long) t + 1);
                map.remove(index);
            }
        }

        return false;
     }
}
