package solution;

/**
 * https://leetcode.com/articles/find-peak-element/
 */
public class FindPeakElement {
    /**
     * 首先局部峰值有很多
     * 1，如果nums[mid]>nums[mid+1]，说明当前递减，左边肯定有个峰值，因为如果
     * 没有，则意味着往左走会不停地上升，走到头的时候因为是负无穷，所以也相当于峰值
     * 右边不一定有峰值，因为可能一直是下降趋势
     * 2，如果nums[mid]<nums[mid+1]，说明当前是上升趋势，右边肯定有个峰值，理由同上
     * 3，题目说了不存在nums[i]=nums[i+1]的情况
     */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

