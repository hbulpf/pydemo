class Solution(object):
    def stair(self,n):
        if n==1 or n==0:
            return 1
        else:
            return self.stair(n-1)+self.stair(n-2)
