class Solution():
    def setcount(self,n,m):
        if m==1 or n==m:
            return 1
        else:
            return self.setcount(n-1,m-1)+self.setcount(n-1,m)*m
