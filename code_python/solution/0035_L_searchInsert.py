#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2022/1/9 16:22
@Author: RunAtWorld
@File: 0035_L_searchInsert.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        """
        在二分法的基础上稍微改造一下。注意最后 target 不在数组中时，索引为  (lo + hi) // 2 + 1
        """
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] < target:
                lo = mid + 1
            elif nums[mid] > target:
                hi = mid - 1
            else:
                return mid
        return (lo + hi) // 2 + 1
