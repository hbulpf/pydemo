#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/23 20:28
@Author: RunAtWorld
@File: removeDuplicates.py
"""
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        """
        使用逆序删除，巧妙避开删除元素时引起数组长度变化的影响
        :param nums:
        :return:
        """
        if not nums:
            return len(nums)
        for i in range(len(nums)-1,0,-1):
            if nums[i] == nums[i-1]:
                nums.pop(i)
        return len(nums)

    def removeDuplicates3(self, nums: List[int]) -> int:
        """
        双指针
        注意: 删除元素时会引起数组长度变化,因此删除时从后面开始删除
        :param nums:
        :return:
        """
        if not nums:
            return len(nums)
        l = 0
        r = 1
        size = len(nums)
        while r < size:
            if nums[l] == nums[r]:
                r += 1
                continue
            else:
                l += 1
                nums[l] = nums[r]
                r += 1
        for k in range(l + 1, size):
            nums.pop(-1)
        return l + 1

    def removeDuplicates2(self, nums: List[int]) -> int:
        if not nums:
            return len(nums)
        cnt = 0
        i = 0
        size = len(nums)
        while i < size:
            cnt += 1
            j = i + 1
            while j < size and nums[i] == nums[j]:
                j += 1
            i = j
        return cnt


if __name__ == '__main__':
    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    solution = Solution()
    print(solution.removeDuplicates(nums))
    print(nums)
