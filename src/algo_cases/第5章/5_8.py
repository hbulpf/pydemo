class Player:
    def num(self, Array):
        self.directions = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        m=len(Array)
        n=len(Array[0])
        re=0
        for i in range(0,n):
            if(Array[0][i]==1):
                Array[0][i]=0
                self.dfs(0,i,Array,m,n)
            if(Array[m-1][i]==1):
                Array[m-1][i]=0
                self.dfs(m-1,i,Array,m,n)
        for j in range(1,m-1):
            if(Array[j][0]==1):
                Array[j][0]=0
                self.dfs(j,0,Array,m,n)
            if(Array[j][n-1]==1):
                Array[j][n-1]=0
                self.dfs(j,n-1,Array,m,n)
        for array in Array:
            re+=array.count(1)
        return re
    def dfs(self,i,j,Array,m,n):
        for l in self.directions:
            x0=i+l[0]
            y0=j+l[1]
            if 0<=x0<m and 0<=y0<n and Array[x0][y0]==1:
                Array[x0][y0]=0
                self.dfs(x0,y0,Array,m,n) 
