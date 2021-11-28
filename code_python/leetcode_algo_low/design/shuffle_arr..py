#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/28 22:13
@Author: RunAtWorld
@File: shuffle_arr..py
@Project: PyCharm
"""
from typing import List
import random


class Solution:
    """
    等概率选择每个位置应该填哪个数。
    """

    def __init__(self, nums: List[int]):
        self.nums = nums

    def reset(self) -> List[int]:
        return self.nums

    def shuffle(self) -> List[int]:
        """
        使用random函数
        """
        copy_nums = self.nums[:]
        for i in range(len(copy_nums)):
            j = random.randrange(i,len(copy_nums))
            copy_nums[i], copy_nums[j] = copy_nums[j], copy_nums[i]
        return copy_nums

    def shuffle2(self) -> List[int]:
        """
        使用python的random.shuffle()函数
        """
        copy_nums = self.nums[:]
        random.shuffle(copy_nums)
        return copy_nums


if __name__ == '__main__':
    solution = Solution([1, 2, 3, 4, 5, 6, 7, 8])
    solution.shuffle()
    solution.reset()
    print("====")
    solution.shuffle()

    print("++++")

    solution = Solution([-6, 10, 184])
    solution.shuffle()
    solution.reset()
    print("====")
    solution.shuffle()

# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
