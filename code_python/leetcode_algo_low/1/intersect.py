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
        return [nums1.pop(nums1.index(i)) for i in nums2 if i in nums1]

    def intersect2(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        Map法
        把nums1数组转化为 map, 遍历 nums2，nums2 的元素在 map 中,value减一
        """
        nums1_map = {}
        res = []
        for i in nums1:
            if nums1_map.get(i):
                tmp = nums1_map.get(i)
                tmp += 1
                nums1_map[i]=tmp
            else:
                nums1_map[i] = 1
        for j in nums2:
            if nums1_map.get(j):
                if nums1_map.get(j) > 0:
                    res.append(j)
                    tmp = nums1_map.get(j)
                    tmp -= 1
                    nums1_map[j] = tmp
        return res


    def intersect1(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        双指针
        如果数字小，就让该指针一直往下走，直到两个数相同,两个指针一起往后走。循环直到其中一个数组遍历完
        :param nums1:
        :param nums2:
        :return:
        """
        nums1.sort()
        nums2.sort()
        res = []
        i = 0
        j = 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] > nums2[j]:
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                res.append(nums1[i])
                i += 1
                j += 1
        return res


if __name__ == '__main__':
    solution = Solution()
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]
    print(solution.intersect(nums1, nums2))  # [2, 2]

    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]
    print(solution.intersect(nums1, nums2))  # [4,9]
