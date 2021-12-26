#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/26 23:08
@Author: RunAtWorld
@File: union_find.py
@Project: PyCharm
"""


class UnionFind:
    """
    并查集
    """

    def __init__(self, n):
        self.__parents = list(range(n))
        self.__rank = [1] * n

    def find(self, x):
        if self.__parents[x] == x:
            return x
        else:
            self.__parents[x] = self.find(self.__parents[x])
            return self.__parents[x]

    def union(self, x, y):
        x_root = self.find(x)
        y_root = self.find(y)
        if x_root == y_root:
            # 已经在同一集合中
            return False

        if self.__rank[x_root] <= self.__rank[y_root]:
            small = x_root
            large = y_root
        else:
            small = y_root
            large = x_root
        self.__parents[small] = large

        if self.__rank[small] == self.__rank[large]:
            self.__rank[large] += 1
        return True


if __name__ == '__main__':
    n = 9
    union_and_find = UnionFind(n)
    for i in range(n - 1):
        union_and_find.union(i, i + 1)

    for i in range(n):
        print(union_and_find.find(i), end=',')
