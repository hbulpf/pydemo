#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/25 21:36
@Author: RunAtWorld
@File: moveZeroes.py
"""
from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        双指针
        关键在于理解 快指针和满指针之间填充的是0
        """
        fast = 0
        slow = 0
        while fast < len(nums):
            if nums[fast] != 0:
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow+=1
            fast += 1

    def moveZeroes1(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        cnt = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i - cnt] = nums[i]
            else:
                cnt += 1
        for i in range(1, cnt + 1):
            nums[-i] = 0


if __name__ == '__main__':
    solution = Solution()
    nums1 = [0, 1, 0, 3, 12]
    solution.moveZeroes(nums1)
    print(nums1)  # [1,3,12,0,0]
