import java.util.HashMap;

public class TwoSum {

    /**
     * one pass
     * 要注意map.put要放在for末尾，对于case[3, 3], target=6的情况，如果放在开头会覆盖第一个3
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
