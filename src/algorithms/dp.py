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
    if n == 0 or n == 1:
        return 1
    n0 = 1
    n1 = 1
    n2 = 2
    for i in range(1, n):
        n2 = n0 + n1
        n0 = n1
        n1 = n2
    return n2


def climbStairs(self, n):
    """
    动态规划，解题思路同fabonaci数列
    f(1) = 1
    f(2) = 2
    f(3) = f(2)+f(1)
    ...
    f(n) = f(n-1)+f(n-2)
    """
    if n == 1:
        return 1
    if n == 2:
        return 2
    l = 1
    r = 2
    for i in range(3, n + 1):
        _sum = l + r
        l = r
        r = _sum
    return r


if __name__ == '__main__':
    print(fabonaci_dp(4))
    print(fabonaci(4))
    print(fabonaci_dp(5))
    print(fabonaci(5))
    print(fabonaci_dp(6))
    print(fabonaci(6))
    print(fabonaci_dp(35))
    print(fabonaci(35))
