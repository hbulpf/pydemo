#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
344. 反转字符串
@Time : 2022/1/12 0:13
@Author: RunAtWorld
@File: 0344_L_reverseString.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        for i in range(len(s) // 2):
            s[i], s[-(i + 1)] = s[-(i + 1)], s[i]

    def reverseString2(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        s[:] = s[::-1]
