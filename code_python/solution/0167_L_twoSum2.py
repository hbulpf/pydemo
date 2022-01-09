#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
167. 两数之和 II - 输入有序数组
@Time : 2022/1/9 23:09
@Author: RunAtWorld
@File: 0167_L_twoSum2.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        """
        使用dict
        """
        num_dict = dict()
        for i, v in enumerate(numbers):
            diff = target - v
            if num_dict.get(diff) is not None:
                return [num_dict[diff] + 1, i + 1]
            else:
                num_dict[v] = i

    def twoSum2(self, numbers: List[int], target: int) -> List[int]:
        """
        根据题目中的 仅存在一个有效答案 和 非递减序列 两个条件，可以采用双指针向中间夹逼的办法。
        """
        lo = 0
        hi = len(numbers) - 1
        while lo < hi:
            if numbers[lo] + numbers[hi] > target:
                hi -= 1
            elif numbers[lo] + numbers[hi] < target:
                lo += 1
            else:
                return [lo + 1, hi + 1]
