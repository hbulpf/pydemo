#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/28 14:40
@Author: RunAtWorld
@File: dp.py
"""


def fabonaci(n):
    """
    输出斐波那契数列第 n 个数
    """
    if n == 0 or n == 1:
        return 1
    return fabonaci(n - 1) + fabonaci(n - 2)

def fabonaci_dp(n):
    """
    使用dp算法输出斐波那契数列第 n 个数
    """


if __name__ == '__main__':
    print(fabonaci(4))
    print(fabonaci(100))