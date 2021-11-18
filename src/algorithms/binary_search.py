#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/18 23:51
@Author: RunAtWorld
@File: binary_search.py
@Project: PyCharm
"""


def binary_search(arr, key):
    left = 0
    right = len(arr) - 1
    while left <= right:
        # 特别注意这里的 <=
        mid = (left + right) // 2
        if arr[mid] < key:
            left = mid
        elif arr[mid] > key:
            right = mid
        else:
            return mid
    return -1


def test1():
    arr = [4, 2, 5, 2, 8, 0, -1, 3, 7]
    arr.sort()
    print(arr, ":", binary_search(arr, 5))
    print(arr, ":", binary_search(arr, 2))

if __name__ == '__main__':
    test1()
