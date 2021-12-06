#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/6 21:17
@Author: RunAtWorld
@File: L836_isRectangleOverlap.py
"""
from typing import List


class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        """
        如果rec1和rec2重叠，则rec1和rec2在x轴和y轴上的投影都是重叠的。
        这就变成了两条线段重叠的问题。两条线段重叠有 (x1,x2),(x3,x4): max(x1,x3)<min(x2,x4)
        :param rec1:
        :param rec2:
        :return:
        """
        return max(rec1[0], rec2[0]) < min(rec1[2], rec2[2]) \
               and max(rec1[1], rec2[1]) < min(rec1[3], rec2[3])

    def isRectangleOverlap1(self, rec1: List[int], rec2: List[int]) -> bool:
        """
        固定rec1,考虑 rec2与rec1不重叠。则 rec2 分别在rec1 的上下左右边
        :param rec1:
        :param rec2:
        :return:
        """
        return not (rec1[2] <= rec2[0]
                    or rec1[0] >= rec2[2]
                    or rec1[3] <= rec2[1]
                    or rec1[1] >= rec2[3])
