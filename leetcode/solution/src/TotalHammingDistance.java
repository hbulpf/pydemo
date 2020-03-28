public class TotalHammingDistance {
    /**
     * 思路是依次遍历每个数字的第i位，统计出为1的有m个，为0的有n个，则在这一位上
     * 增加的hamming distance为m*n个
     */
    /**
     * 复杂度为O(n)
     */
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int a = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) != 0) {
                    a++;
                }
                nums[j] >>>= 1;
            }
            res += a * (nums.length - a);
        }
        return res;
    }
}
