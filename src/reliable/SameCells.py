#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
合并表格
@Time : 2022/1/14 17:19
@Author: RunAtWorld
@File: SameCells.py
"""
from typing import List


class Solution:
    def same_cells(self, n: int, m: int, cells: List) -> int:
        ans = 0
        for i in range(n):
            for j in range(m):
                if i == 0:
                    ans += 1
                    continue
                if cells[i][j] == cells[i - 1][j] and self.front_same(cells, i, j):
                    continue
                ans += 1
        return ans

    def front_same(self, cells, row, col):
        ok = True
        for i in range(col):
            if cells[row - 1][i] != cells[row][i]:
                ok = False
                break
        return ok


if __name__ == '__main__':
    cells = [
        ['A', 'B', 'C'],
        ['A', 'B', 'D'],
        ['A', 'B', 'D'],
        ['E', 'F', 'G'],
        ['E', 'H', 'I']
    ]
    solution = Solution()
    print(solution.same_cells(5, 3, cells))
