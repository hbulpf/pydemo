package solution;

/**
 * 核心思路就是对于每根柱子，找到其左边最高的柱子和右边最高的柱子，构成一个桶，形成一个水平面，然后对该柱子形成的高度差就是能装的水
 */
public class TrappingRainWater {

    // 耗时24ms
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int rain = 0;
        for (int i = 1; i < height.length - 1; i++) {
            rain += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return rain;
    }
}
