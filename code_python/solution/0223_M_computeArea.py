#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/6 21:37
@Author: RunAtWorld
@File: M223_computeArea.py
"""


class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        """
        覆盖面积为 A+B-C
        :param ax1:
        :param ay1:
        :param ax2:
        :param ay2:
        :param bx1:
        :param by1:
        :param bx2:
        :param by2:
        :return:
        """
        area_a = (ax2 - ax1) * (ay2 - ay1)
        area_b = (bx2 - bx1) * (by2 - by1)
        overlap = max(min(ax2, bx2) - max(ax1, bx1), 0) * max(min(ay2, by2) - max(ay1, by1), 0)
        return area_a + area_b - overlap
