class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        f(1) = 1
        f(2) = 2
        f(3) = f(2)+f(1)
        ...
        f(n) = f(n-1)+f(n-2)
        """
        if n == 1: return 1
        if n == 2: return 2
        l = 1
        r = 2
        for i in range(3,n+1):
            sum_ = l+r
            l = r
            r = sum_
        return r