#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
189. 轮转数组
@Time : 2022/1/9 20:15
@Author: RunAtWorld
@File: 0189_rotateArray.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:


    def rotate2(self, nums: List[int], k: int) -> None:
        nums = nums[-k:] + nums[:-k]


if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5, 6, 7]
    solution = Solution()
    solution.rotate(nums, 3)
