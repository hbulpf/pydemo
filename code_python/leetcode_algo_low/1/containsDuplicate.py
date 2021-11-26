#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/24 23:57
@Author: RunAtWorld
@File: containsDuplicate.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)

    def containsDuplicate1(self, nums: List[int]) -> bool:
        if not nums:
            return False
        nums.sort()
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                return True
        return False


if __name__ == '__main__':
    solution = Solution()
    nums = [1, 2, 3, 1]
    print(solution.containsDuplicate(nums))

    nums = [1,2,3,4]
    print(solution.containsDuplicate(nums))