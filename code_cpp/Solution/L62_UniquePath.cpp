/**
 * 题目：62.不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 例如下列地图,其中s为起点，e为终点：
 *          s # # # #
 *          # # # # #
 *          # # # # e
 * 示例：
 * 输入：m=3,n=2
 * 输出：3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 
 * 题解：
 * 令dp[i][j]是到达i,j的路径和
 * 对于第一行和第一列有d[0][j]=1,d[i][0]=1
 * 其他单元格：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 
 **/

class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        vector<vector<int>> dp(m,vector<int>(n,0));

        for(int i=0;i<n;i++)
            dp[0][i] = 1;
        
        for(int j=0;j<m;j++)
            dp[j][0] = 1;

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        
        return dp.back().back();
    }
};