/**
 * 题目：最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 题解：
 * 动态规划
 * 设dp[i]为以nums[i]为尾元素的具有最大和的连续子序列，
 * 则满足： dp[i] =  max(dp[i-1],nums[i])
 * 其中根据dp[i]定义可知：
 * dp[i]必定包含nums[i]，但不一定包含nums[i-1]，
 * 若包含nums[i-1],则其结构可以分解为dp[i-1] + nums[i]，即：nums[i]和以nums[i-1]的最大和连续子序列
 * 
 * */
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int len = nums.size();
        int res = nums[0], tmp = nums[0];
        for(int i=1;i<len;i++)
        {
            if(tmp + nums[i] > nums[i])
                tmp = tmp +nums[i];
            else
                tmp = nums[i];
            if(res < tmp)
                res = tmp;
        }
        return res;
    }
};