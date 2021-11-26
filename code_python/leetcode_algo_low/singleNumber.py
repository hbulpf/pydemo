#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/25 0:04
@Author: RunAtWorld
@File: singleNumber.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        """
        题目的关键是其余每个元素均出现两次
        异或运算: a^a = 0 ;0^a = a
        异或运算 满足交换律 a^b^a = a^a^b = b
        """
        reduct = 0
        for i in nums:
            reduct ^= i
        return reduct

    def singleNumber1(self, nums: List[int]) -> int:
        """
        设置 cnt 计数位。
        先排序，如果一个数和前后两个都不相同，则 cnt = 2; 如果一个数和后一个相同，则 cnt = 0.
        cnt = 2 时，即为那个出现了一次的数字
        注意: 这个方法取了个巧: 由于第一个数字没办法和前一个比较，所以就默认和前一个不同，cnt = 1; 最后一个数字也没办法和后一个比较，
            但如果前面的数字都不是出现一次的数字，那最后一个就是。
        """
        nums.sort()
        cnt = 1
        for i in range(len(nums) - 1):
            if nums[i] == nums[i + 1]:
                cnt = 0
            else:
                cnt += 1
            if cnt == 2:
                return nums[i]
        return nums[-1]


if __name__ == '__main__':
    solution = Solution()
    nums = [2, 2, 1]
    res = solution.singleNumber(nums)
    print(res)
    assert res == 1

    nums = [4, 1, 2, 1, 2]
    res = solution.singleNumber(nums)
    print(res)
    assert res == 4
