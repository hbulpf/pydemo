#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/28 20:42
@Author: RunAtWorld
@File: rotateImg.py
@Project: PyCharm
"""
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        width = len(matrix)
        k = width // 2
        for i in range(k):
            for j in range(i, width - i -1):
                m = width - i - 1
                n = width - j - 1
                tmp = matrix[i][j]
                matrix[i][j] = matrix[n][i]
                matrix[n][i] = matrix[m][n]
                matrix[m][n] = matrix[j][m]
                matrix[j][m] = tmp


if __name__ == '__main__':
    solution = Solution()
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    solution.rotate(matrix)  # [[7,4,1],[8,5,2],[9,6,3]]
    print(matrix)

    matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
    solution.rotate(matrix)  # [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    print(matrix)

    matrix = [[1]]
    solution.rotate(matrix)  # [[1]]
    print(matrix)

    matrix = [[1, 2], [3, 4]]
    solution.rotate(matrix)  # [[3,1],[4,2]]
    print(matrix)
