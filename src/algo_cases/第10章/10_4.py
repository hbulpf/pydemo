class Solution:
    def func(self, grid):
        re=0
        self.directions=[[1,0],[-1,0],[0,1],[0,-1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]!=0:
                    re=max(re,self.dfs(i,j,grid))
        return re
    def dfs(self,i,j,grid):
        if len(grid)<=i or i<0 or len(grid[0])<=j or j<0 or grid[i][j]==0:
              return 0
        current_value=grid[i][j]
        grid[i][j]=0
        max_=0
        for direction in self.directions:
            re=max(max_,self.dfs(i+direction[0],j+direction[1],grid))
        grid[i][j]=current_value
        return max_+current_value
