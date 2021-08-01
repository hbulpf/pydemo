package solution;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * (1) 暴力法 T=O(N^2),S=O(1)
 * (2) 双指针法 T=O(N),S=O(1)
 * 题目的意思是选定两块板子组成一个桶，使得装水量最大。注意其余的板子都忽略。
 * 一种O(n)的方法是对于区间[left, right]，假如height[left] < height[right]，则我们可以认定[left, right - 1]，[left, right - 2] ...
 * 都不会比[left, right]装的水更多。原因是木桶的短板没变，所以水平面不会变，但是宽度减小了。
 * 所以我们要继续尝试的方向是从较短的一方推进，寄希望于其之后的板子能高一点
 * 如果两边一样高，那随便推进哪一边都行，因为假如之后还能装更多水，一定不会包含这两边任意一块。如果包含了，水量不会超过当前。
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;

        for (int left = 0, right = height.length - 1; left < right; ) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int ans;
        ans=maxArea1(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ans);

        ans=maxArea2(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ans);
    }

    /**
     * 暴力法
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;
    }

    /**
     * 双指针法
     * l 为左指针，从左边开始；r为右指针，从右边开始
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0, max = 0;
        while (l < r) {
            area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(area, max);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
