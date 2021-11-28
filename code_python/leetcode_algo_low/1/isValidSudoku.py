#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/26 23:52
@Author: RunAtWorld
@File: isValidSudoku.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        """
        暴力的基础上稍微改进: 创建三个数组，把数字放到对应的数组，然后判断是否重复
        """
        row = [[0] * 9] * 9
        col = [[0] * 9] * 9
        box = [[0] * 9] * 9
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == '.':
                    continue
                num = ord(board[i][j]) - ord('0') - 1
                row[i][num] += 1
                col[j][num] += 1
                # k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                k = int(i / 3) * 3 + int(j / 3)
                box[num][k] += 1
                if row[i][num] > 1 or col[j][num] > 1 or box[num][k] > 1:
                    return False
        return True

    def isValidSudoku1(self, board: List[List[str]]) -> bool:
        """
        暴力法: 直接横、竖、逐个小方格 遍历
        """
        for row in board:
            row_nums = filter(lambda x: x != '.', row)
            if self.isRepetated(list(row_nums)):
                return False
        for c in range(9):
            col_nums = []
            for r in range(9):
                if board[r][c] != '.':
                    col_nums.append(board[r][c])
            if self.isRepetated(list(col_nums)):
                return False
        for r in range(0, 9, 3):
            for c in range(0, 9, 3):
                nine_nums = []
                for i in range(3):
                    for j in range(3):
                        if board[r + i][c + j] != '.':
                            nine_nums.append(board[r + i][c + j])
                if self.isRepetated(list(nine_nums)):
                    return False
        return True

    def isRepetated(self, nums: List[str]) -> bool:
        return len(set(nums)) != len(nums)


if __name__ == '__main__':
    solution = Solution()
    board = \
        [["5", "3", ".", ".", "7", ".", ".", ".", "."]
            , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
            , [".", "9", "8", ".", ".", ".", ".", "6", "."]
            , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
            , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
            , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
            , [".", "6", ".", ".", ".", ".", "2", "8", "."]
            , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
            , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    print(solution.isValidSudoku(board))
