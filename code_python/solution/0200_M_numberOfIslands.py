#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/9/14 23:45
@Author: RunAtWorld
@File: M200_numberOfIslands.py
"""
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = [[0] * len(grid[0])] * len(grid)

        def dfs(row, col, grid: List[List[str]]) -> int:
            if visited[row][col] or grid[row][col] == "0":
                return 0
            visited[row][col] = 1
            if row > 0:
                if grid[row - 1][col] == "1":
                    dfs(row - 1, col, grid)
            if row < len(grid) - 1:
                if grid[row + 1][col] == "1":
                    dfs(row + 1, col, grid)
            if col > 0:
                if grid[row][col - 1] == "1":
                    dfs(row, col - 1, grid)
            if col < len(grid[0]) - 1:
                if grid[row][col + 1] == "1":
                    dfs(row, col + 1, grid)
            return 1

        num_islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if not visited[i][j]:
                    num_islands += 1 if dfs(i, j, grid) else 0
                    print(num_islands, "==>", i, j, visited)
        return num_islands


if __name__ == '__main__':
    solution = Solution()
    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
    res = solution.numIslands(grid)
    print(res)
    assert 1 == res

    print("--------")
    grid = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"]
    ]
    res = solution.numIslands(grid)
    print(res)
    assert 3 == res

    print("--------")
    grid = [
        ["0", "1", "0"],
        ["1", "0", "1"],
        ["0", "1", "0"]
    ]
    res = solution.numIslands(grid)
    print(res)
    assert 4 == res
