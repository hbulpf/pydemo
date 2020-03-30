package solution;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesII {

    /**
     * 这题思路是维护一个窗口[l,h]
     * 这个窗口满足条件为0的个数小于等于k，这样这些0都能翻转成1，窗口的大小就是连续的1的个数了
     * 如果遇到一个新的0，要判断当前窗口的0是否超了，如果超了，则窗口左边要收缩直到0的个数仍小于等于k为止
     */
    public int findMaxConsecutiveOnes(int[] nums, int k) {
        int max = 0, zero = 0;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[l++] == 0) {
                    zero--;
                }
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    /**
     * for follow  up
     * follow up的意思是说这是个数据流，不能像上面那样随机访问元素
     * 这里用一个队列保存0元素的index，当新来一个0使得队列的size超过k时，队列要poll一个0
     */
    public int findMaxConsecutiveOnes2(int[] nums, int k) {
        int max = 0;
        Queue<Integer> zeroIndex = new LinkedList<>();
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                zeroIndex.offer(h);
            }
            if (zeroIndex.size() > k) {
                l = zeroIndex.poll() + 1;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
}
