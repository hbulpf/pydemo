def uniquePaths(self, m, n):
    dp=[]
    for i in range(n):#初始化
        dp.append([0]*m)
    for i in range(n):
        dp[i][0]=1
    dp[0]=[1]*m
    for i in range(1,n):
        for j in range(1,m):
            dp[i][j]=dp[i-1][j]+dp[i][j-1]
    return dp[n-1][m-1]


import math #导入库函数
def uniquePaths(self, m, n):
    return  math.factorial(m+n-2)/math.factorial(n-1)/math.factorial(m-1)
