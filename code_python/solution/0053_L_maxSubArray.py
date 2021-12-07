class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        1.定义一个函数f(n)，以第n个数为结束点的子数列的最大和，存在一个递推关系f(n) = max(f(n-1) + A[n], A[n]);
        2.将这些最大和保存下来后，取最大的那个就是，最大子数组和。因为最大连续子数组 等价于 最大的以n个数为结束点的子数列和 附代码

        """
        max_num = []
        max_num.append(nums[0])
        for i in range(1,len(nums)):
            max_num.append(max(max_num[i-1]+nums[i],nums[i]))
        return max(max_num)
