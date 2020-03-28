public class JumpGameII {

    /**
     * 动态规划
     */
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            steps[i] = i;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        return steps[nums.length - 1];
    }

    /**
     * longestJump表示jumps步最远能到的距离
     * maxJump表示以[0,i]为起点能覆盖到的最远距离
     */
    public int jump2(int[] nums) {
        int longestJump = 0, maxJump = 0, jumps = 0;

        for (int i = 0; i < nums.length; i++) {
            // 表示i-1时还覆盖得到，而i覆盖不到了，所以更新为[0,i-1]时的maxJump
            if (longestJump < i) {
                longestJump = maxJump;
                jumps++;
            }

            maxJump = Math.max(maxJump, nums[i] + i);
        }

        return jumps;
    }


}
