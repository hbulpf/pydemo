#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/25 0:33
@Author: RunAtWorld
@File: intersect.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        nums1.sort()
        nums2.sort()
        print(nums1,nums2)
        res = []
        i = 0
        j = 0
        while i < len(nums1):
            while j < len(nums2) and nums1[i] != nums2[j]:
                j += 1
            else:
                if j >= len(nums2):
                    break
                else:
                    res.append(nums1[i])
                i += 1
        return res


if __name__ == '__main__':
    solution = Solution()
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]
    print(solution.intersect(nums1, nums2))  # [2, 2]

    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]
    print(solution.intersect(nums1, nums2))  # [4,9]
