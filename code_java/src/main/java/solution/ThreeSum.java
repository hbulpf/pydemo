package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * 这题重要的是查重
 * 两重循环都要查重
 * <p>
 * 解法：
 * 1. 双指针
 *
 * @Author: RunAtWorld
 * @Date: 2020/6/19 0:01
 */
public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum1(nums));
    }

    /**
     * 双指针法
     * O(T)=O(N^2)+O(N*logN)
     * O(S)=O(N)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        //枚举a
        for (int first = 0; first < len; first++) {
            // first > 0 的条件保证 a=0 被枚举一次
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;
            //枚举b
            for (int second = first + 1; second < len; second++) {
                // second > first + 1 的条件保证 b=first + 1 被枚举一次
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                //枚举c
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }
                // 如果 b 和 c指针重合，就不会再有 b增加， a+b+c=0
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> oneTuple = new ArrayList();
                    oneTuple.add(nums[first]);
                    oneTuple.add(nums[second]);
                    oneTuple.add(nums[third]);
                    res.add(oneTuple);
                }
            }
        }
        return res;
    }

    // 耗时30ms
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    for (j++, k--; j < k && nums[j] == nums[j - 1]; j++) ;
                }
            }
        }

        return result;
    }
}
