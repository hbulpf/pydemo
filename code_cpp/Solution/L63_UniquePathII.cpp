/**
 * 题目：63. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 示例：
 * 输入:
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 题解：
 * 与62的解法相似，但是当遇到障碍物时，即obstacleGrid[i][j]==1，则dp[i][j]=0,
 * 且初始化时dp[i][0],dp[0][j]不一样，
 * 一旦遇到障碍物,即：obstacleGrid[i][0]==1或obstacleGrid[0][j]==1，
 * dp[i][0]或dp[0][j]自身及以后的值为0
 * 
 **/


class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        if(m == 0) return 0;
        int n = obstacleGrid[0].size();
        if(n == 0) return 0;
        vector<vector<long>> dp(m,vector<long>(n,0));

        for(int j=0;j<n;j++)
        {
            if(obstacleGrid[0][j] == 1)
            {    
                dp[0][j] = 0;
                break;
            }else
            {
                dp[0][j] = 1;    
            }
        }

        for(int i=0;i<m;i++)
        {
            if(obstacleGrid[i][0] == 1)
            {    
                dp[i][0] = 0;
                break;
            }else
            {
                dp[i][0] = 1;    
            }
        }

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    dp[i][j] = 0;
                }else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        return dp.back().back();
    }
};