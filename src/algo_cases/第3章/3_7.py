class Solution:
    def UglyNum(self, n):
        dp=[0]*n
        dp[0]=1
        p2=p3=p5=0
        for i in range(1,n):
            dp[i]=min(2*dp[p2],3*dp[p3],5*dp[p5])
            if dp[i]==2*dp[p2]:
                p2+=1
            if dp[i]==3*dp[p3]:
                p3+=1
            if dp[i]==5*dp[p5]:
                p5+=1
        return dp[-1]
