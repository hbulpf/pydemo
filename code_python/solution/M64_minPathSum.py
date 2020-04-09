class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        m: 行数
        n: 列数
        """
        m = len(grid)
        n = len(grid[0])
        for i in range(1,m):
            grid[i][0] = grid[i][0]+grid[i-1][0]
        for j in range(1,n):
            grid[0][j] = grid[0][j]+grid[0][j-1]
        for i in range(1,m):
            for j in range(1,n):
                grid[i][j] = min(grid[i-1][j],grid[i][j-1])+grid[i][j]
        return grid[-1][-1]