#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
704. 二分查找
@Time : 2022/1/7 11:09
@Author: RunAtWorld
@File: 0704_L_binarySearch.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return mid
        return -1