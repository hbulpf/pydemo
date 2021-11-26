#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/25 20:59
@Author: RunAtWorld
@File: plusOne.py
"""
from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        """
        主要靠观察
        """
        length = len(digits)
        i = length - 1
        while i >= 0:
            if digits[i] < 9:
                digits[i] += 1
                return digits
            else:
                digits[i] = 0
            i -= 1
        digits.insert(0, 1)
        return digits

    def plusOne1(self, digits: List[int]) -> List[int]:
        length = len(digits)
        i = length - 1
        flag = 0
        while i >= 0:
            if (digits[i] + 1) > 9 or (digits[i] + flag) > 9:
                digits[i] = 0
                flag = 1
            else:
                digits[i] += 1
                return digits
            i -= 1
        if i == -1 and flag == 1:
            digits.insert(0, 1)
        return digits


if __name__ == '__main__':
    solution = Solution()
    # nums = [1, 2, 3]
    # print(solution.plusOne(nums))  # [1,2,4]
    #
    # nums = [4, 3, 2, 1]
    # print(solution.plusOne(nums))  # [4,3,2,2]
    #
    # nums = [0]
    # print(solution.plusOne(nums))  # [1]

    nums = [9]
    print(solution.plusOne(nums))  # [1]