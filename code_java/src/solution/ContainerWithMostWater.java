/**
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
}
