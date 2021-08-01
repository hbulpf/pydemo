package others.chrysanthemum;

/**
 * 十进制整数数组，按位与操作
 * 给定一个数组 int[] {23, 12, 10, 8, 7, 45, 16} , 求位运算最大的两个数字，返回位置。
 *
 */
public class Main2 {
    public int[] findMaxValuePosition(int[] nums) {
        int[] res = new int[2];
        int max = Integer.MIN_VALUE;
        res[0] = 0;
        res[1] = 1;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = nums[i] & nums[j];
                if (max < tmp) {
                    max = tmp;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public int calAnd(int num1, int num2) {
        return num1 & num2;
    }
}
