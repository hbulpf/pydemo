class Pattern:
    def num(self, grid):
        self.length = len(grid)
        if self.length == 0:
            return 0
        self.width = len(grid[0])
        self.directions = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        self.marked = [[0 for _ in range(self.width)] for _ in range(self.length)]
        re = 0
        for i in range(self.length):
            for j in range(self.width):
                if  self.marked[i][j]==0 and grid[i][j] == '1':
                    re += 1
                    self.dfs(grid, i, j)
        return re
    def dfs(self, grid, i, j):
        self.marked[i][j] = 1
        for x in range(4):
            x0= i + self.directions[x][0]
            y0= j + self.directions[x][1]
            if 0<=x0<self.length and 0<=y0<self.width and self.marked[x0][y0]==0 and 22grid[x0][y0]=='1':
                self.dfs(grid, x0, y0)
