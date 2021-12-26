#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/26 19:46
@Author: RunAtWorld
@File: prior_queue_test.py
@Project: PyCharm
"""


def test_heapq():
    arr = [4, 3, 2, 5, 8, 9, 10, 1]
    import heapq
    heapq.heapify(arr)
    print(heapq.heappop(arr))
    heapq.heappush(arr, 13)
    while arr:
        print(heapq.heappop(arr), end=',')


if __name__ == '__main__':
    test_heapq()
