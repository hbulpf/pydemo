import numpy
class Solution(object):
    # 直接递归，超时
    # def uniquePaths(self, m, n):
    #     """
    #     :type m: int
    #     :type n: int
    #     :rtype: int
    #     """
    #     return self.dfs(1,1,m,n)
    # def dfs(self,x,y,m,n):
    #     """
    #     初始坐标（x,y）
    #     m:列数
    #     n:行数
    #     """
    #     if x>n or y>m: return 0
    #     if x==n and y==m: return 1
    #     right = self.dfs(x,y+1,m,n)
    #     down = self.dfs(x+1,y,m,n)
    #     return right+down
    def uniquePaths(self, m, n):
        """
        动态规划，
        :type m: int 列数
        :type n: int 行数
        :rtype: int
        """
        path_matrx = numpy.zeros((n,m),dtype=int)

        for i in range(n):
            for j in range(m):
                if i==0 or j==0:
                    path_matrx[i][j]=1
                else:
                    path_matrx[i][j] = path_matrx[i-1][j]+path_matrx[i][j-1]
        return path_matrx[n-1][m-1]

