#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/24 20:07
@Author: RunAtWorld
@File: rotate.py
"""
from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        使用 O(1) 的空间复杂度求解
        """
        length = len(nums)
        k %= length
        self.reverse(nums, 0, length)
        self.reverse(nums, 0, k)
        self.reverse(nums, k, length)


    def reverse(self, nums: List[int], start: int, end: int) -> None:
        end -= 1
        while start < end:
            tmp = nums[end]
            nums[end] = nums[start]
            nums[start] = tmp
            start += 1
            end -= 1

    def rotate2(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        利用切片，解法十分简洁
        """
        k %= len(nums)
        # nums[:] = nums[len(nums) - k:] + nums[:len(nums) - k]
        nums[:] = nums[-k:] + nums[:-k]

    def rotate1(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        size = len(nums)
        # 要特别注意 k 可能会超过 nums 的长度
        k %= size
        tmp_arr = [0] * k
        for i in range(size - (k % size), size):
            tmp_arr[i - size + (k % size)] = nums[i]
        print(tmp_arr)
        for i in range(size - 1, -1, -1):
            if i < k:
                nums[i] = tmp_arr[i]
            else:
                nums[i] = nums[i - k]


if __name__ == '__main__':
    solution = Solution()
    nums = [1, 2, 3, 4, 5, 6, 7]
    print(nums)
    solution.rotate(nums, 3)
    print(nums)

    nums = [1, 2]
    solution.rotate(nums, 5)
    print(nums)
