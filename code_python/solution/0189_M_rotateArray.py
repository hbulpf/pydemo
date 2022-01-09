#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
189. 轮转数组
@Time : 2022/1/9 20:15
@Author: RunAtWorld
@File: 0189_rotateArray.py
@Project: PyCharm
"""
from math import gcd
from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        环状替换方法，需要数学证明，不要理解。暂时不懂 cnt = gcd(k, n) 的原因
        :param nums:
        :param k:
        :return:
        """
        n = len(nums)
        cnt = gcd(k, n)
        for start in range(cnt):
            cur_idx = start
            prev_value = nums[start]
            while True:
                next_idx = (cur_idx + k) % n
                nums[next_idx], prev_value = prev_value, nums[next_idx]
                cur_idx = next_idx
                if start >= cur_idx:
                    break

    def reverse(self, nums: List[int], start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    def rotate4(self, nums: List[int], k: int) -> None:
        """
        使用数组反转的方法
        """
        k %= len(nums)
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)
        print(nums)

    def rotate3(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        tail = nums[-k:]
        for i in range(k):
            nums.pop()
        for i in range(1, k + 1):
            nums.insert(0, tail[-i])

    def rotate2(self, nums: List[int], k: int) -> None:
        """
        使用额外的数组完成翻转
        """
        k %= len(nums)
        nums[:] = nums[-k:] + nums[:-k]


if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5, 6, 7]
    solution = Solution()
    solution.rotate(nums, 3)
    nums = [-1]
    solution = Solution()
    solution.rotate(nums, 2)
