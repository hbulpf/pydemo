/**
 * 题目：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * case:
 * input: 2
 * output: 2
 * 解释：有两种方法可以爬到楼顶
 * 1. 1阶 + 1阶
 * 2. 2阶
 * 
 * 解法：
 * 动态规划
 * 第i阶可以由以下两种方法得到：
 * 1. 在第(i-1)阶向上爬一阶
 * 2. 在第(i-2)阶向上爬2阶
 * 题解：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
**/
class Solution {
public:
    int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int a = 1, b = 2;
        for(int i=3;i<=n;i++)
        {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
};