import java.util.Stack;

/**
 * 参考https://leetcode.com/articles/largest-rectangle-histogram/
 */
public class LargestRectangleInHistogram {

    /**
     * 这题关键是对于每根柱子，往两边延伸到某根柱子比自己矮或到边界为止。
     * 暴力办法是依次循环，时间复杂度O(n^2)，空间复杂度O(n)
     * 采用动态规划延伸的时候可以根据之前的结果跳着走，最优时间复杂度O(n)，最差时间复杂度O(n^2)，平均时间复杂度O(n)，空间复杂度O(n)
     * 采用压栈的方法最巧妙，时间复杂度O(n)，空间复杂度O(n)
     */

    // 这种超时了，复杂度O(n^2)
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0, j, k; i < heights.length; i++) {
            for (j = i - 1; j >= 0 && heights[j] >= heights[i]; j--);
            for (k = i + 1; k < heights.length && heights[k] >= heights[i]; k++);
            max = Math.max(max, (k - j - 1) * heights[i]);
        }
        return max;
    }

    /**
     * 核心思路是用栈保存一个高度递增的index，当出现一个局部最高点时，计算以该最高点为高度的最大面积
     * 该局部最高点的形成可能是新加的柱子较矮，也可能是随着旧的高点不断出栈导致的
     * 该局部高点的特点是"相邻的柱子都比他高"，这里相邻的意思是左边延伸到下一个出栈的index，右边延伸到新加的柱子
     *
     * 注意栈中的是index，不是高度
     *  栈保持递增，当出现小于栈顶的元素时，意味着可以计算栈顶可以延伸的矩形面积了
     *  其左边界是次栈顶，右边界是当前元素
     */
    public int largestRectangleArea2(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; ) {
            int height = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || height > heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                /**
                 * top两边都是比top高的
                 * [left,i-1]
                 */
                max = Math.max(max, heights[top] * (i - 1 - left + 1));
            }
        }
        return max;
    }

    // 耗时4ms
    public int largestRectangleArea3(int[] heights) {
        int len = heights.length, j;
        int[] left = new int[len], right = new int[len];

        for (int i = 0; i < len; i++) {
            for (j = i; j >= 1 && heights[j - 1] >= heights[i]; j = left[j - 1]);
            left[i] = j;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (j = i; j < len - 1 && heights[j + 1] >= heights[i]; j = right[j + 1]);
            right[i] = j;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, (right[i] - left[i] + 1) * heights[i]);
        }
        return max;
    }
}
