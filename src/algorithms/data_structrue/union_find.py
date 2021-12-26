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
        self.parents = list(range(n))
        self.rank = [1] * n

    def find(self, x):
        if self.parents[x] == x:
            return x
        else:
            self.parents[x] = self.find(self.parents[x])
            return self.parents[x]

    def union(self,x,y):
        x_root = self.find(x)
        y_root = self.find(y)
        if x_root == y_root:
            # 已经在同一集合中
            return False

        if self.rank[x_root] <= self.rank[y_root]:
            small = x_root
            large = y_root
        else:
            small = y_root
            large = x_root
        self.parents[small] = large

        if self.rank[small] == self.rank[large]:
            self.rank[large] += 1
        return True

