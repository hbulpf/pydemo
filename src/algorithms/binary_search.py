#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/18 23:51
@Author: RunAtWorld
@File: binary_search.py
@Project: PyCharm
"""
from bisect import bisect


def binary_search(arr, key):
    left = 0
    right = len(arr) - 1
    while left <= right:
        # 特别注意这里的 <=
        mid = (left + right) // 2
        if arr[mid] < key:
            left = mid + 1
        elif arr[mid] > key:
            right = mid - 1
        else:
            return mid
    return -1


def continuous_binary_search(f, target, lo, hi):
    while hi - lo > 1e-4:  # 设置精度
        mid = (lo + hi) / 2  # 浮点数除法
        if f(hi) > target:
            hi = mid
        else:
            lo = mid
    return lo


def test_binary_search():
    arr = [4, 2, 5, 2, 8, 0, -1, 3, 7]
    arr.sort()
    print(arr, ":", binary_search(arr, 5))
    print(arr, ":", binary_search(arr, 2))
    print(arr, ":", bisect(arr, 5))

    arr = [4, 2]
    arr.sort()
    print(arr, ":", binary_search(arr, 2))
    print(arr, ":", binary_search(arr, 4))

    print(arr, ":", bisect(arr, 4))


def test_continuous_binary_search():
    f = lambda x: x ** 2
    print(continuous_binary_search(f, 16, 2.22, 9))


if __name__ == '__main__':
    test_continuous_binary_search()
    test_binary_search()
