#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/28 11:41
@Author: RunAtWorld
@File: greedy.py
"""


def min_scalar_prod(x, y):
    x = sorted(x)
    y = sorted(y)
    return sum(x[i] * y[-i - 1] for i in range(len(x)))


if __name__ == '__main__':
    x = [1, 2, 3, 4, 5, 6, 7, 8]
    y = [81, 72, 63, 54, 45, 36, 27, 18]
    print(min_scalar_prod(x, y))
