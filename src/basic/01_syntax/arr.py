#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/19 16:33
@Author: RunAtWorld
@File: arr.py
"""


def wrong_arr():
    M = [[0] * 5] * 5
    print(M)
    M[0][0] = 4
    print(M)
    M[0][1] = 3
    print(M)
    M[1][1] = 5
    print(M)


def right_arr():
    M = [[0] * 5 for _ in range(5)]
    print(M)
    M[0][0] = 4
    print(M)
    M[0][1] = 3
    print(M)
    M[1][1] = 5
    print(M)


def right_arr2():
    M = [[0 for _ in range(5)] for _ in range(5)]
    print(M)
    M[0][0] = 4
    print(M)
    M[0][1] = 3
    print(M)
    M[1][1] = 5
    print(M)


def arr_max():
    tab = [22, 3, 2, 4, 21, 32]
    print(max((tab[i], i) for i in range(len(tab))))
    print(max((-tab[i], i) for i in range(len(tab))))
    print(min((tab[i], i) for i in range(len(tab))))
    b1 = [(1, +1), (2, +1), (3, +1)]
    b2 = [(8, -1), (7, -1), (6, -1)]
    b3 = (b1 + b2)
    print(b3)
    b3.sort()
    print(b3)


if __name__ == '__main__':
    # wrong_arr()
    # print("====")
    # right_arr()
    # print("====")
    # right_arr2()
    print("====")
    arr_max()
