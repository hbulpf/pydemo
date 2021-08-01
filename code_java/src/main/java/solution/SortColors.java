package solution;

public class SortColors {

    /**
     * 从左往右遍历，如果遇到0，左边肯定先是一堆0，然后是1堆1，交换过后，当前肯定是1，所以要i++。
     * 如果遇到2，肯定往右交换，然后交换后的数未知，所以i不能轻举妄动
     */
    // 时间复杂度O(n)，扫一遍
    public void sortColors3(int[] nums) {
        int zero = -1, two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i++);
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    /**
     * 如果要扩展到k个颜色，如果颜色为0~k
     * 原理很简单，就是统计每个颜色的个数，转成负数，保存在原来的数组中
     * 统计完后再根据个数设置数组
     * 其实可以另外开辟一个数组保存个数，如果对空间没有要求的话
     */
    public void sortKColors(int[] colors, int k) {
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] >= 0) {
                int color = colors[i];
                if (colors[color] >= 0) {
                    colors[i] = colors[color];
                    colors[color] = -2;
                } else {
                    colors[color]--;
                    colors[i] = -1;
                }
            }
        }
        for (int i = colors.length - 1; i >= 0; ) {
            int color = --k, count = -(colors[color] + 1);
            for (int j = 0; j < count; j++) {
                colors[i--] = color;
            }
        }
    }

    /**
     * http://www.lintcode.com/zh-cn/problem/sort-colors-ii/
     */
    // 如果颜色从1~k，lint
    public void sortColors2(int[] colors, int k) {
        // write your code here
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] > 0) {
                int color = colors[i];
                if (colors[color - 1] > 0) {
                    colors[i] = colors[color - 1];
                    colors[color - 1] = -1;
                } else {
                    colors[color - 1]--;
                    colors[i] = 0;
                }
            }
        }
        int color = k - 1;
        for (int i = colors.length - 1; i >= 0; ) {
            for (int j = 0; j < -colors[color]; j++) {
                colors[i--] = color + 1;
            }
            color--;
        }
    }
}
