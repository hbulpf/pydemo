class Solution(object):
    def monkey(self,n):
        if n==1:
            return 1
        else:
            return (self.monkey(n-1)+1)*2
