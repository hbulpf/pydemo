#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
283. 移动零
@Time : 2022/1/9 22:27
@Author: RunAtWorld
@File: 0283_L_moveZeroes.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left = right = 0
        while right < len(nums):
            if nums[right] != 0:
                nums[left] = nums[right]
                left += 1
            right += 1
        for i in range(left, len(nums)):
            nums[i] = 0
