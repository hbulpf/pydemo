package solution;

import java.util.HashMap;

/**
 * https://leetcode.com/articles/subarray-sum-equals-k/
 */

public class SubarraySumEqualsK {

    /**
     * 注意map.put(0,1)，即当前数自己也算是一种
     * TestCase [1], 0，即k=0的情况
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            // 以下两句顺序非常重要，因为两个差要至少相差一个数以上，因此不能刚给当前sum放到Map就参与运算
            // 比如k=0，如果刚给sum放到map就参与运算，那么sum-sum=0的情况是非法的
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
