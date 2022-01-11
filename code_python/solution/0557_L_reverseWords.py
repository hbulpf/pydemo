#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
557. 反转字符串中的单词 III
@Time : 2022/1/12 0:17
@Author: RunAtWorld
@File: 0557_L_reverseWords.py
@Project: PyCharm
"""


class Solution:
    def reverseWords(self, s: str) -> str:
        str_arr = s.split(" ")
        for i in range(len(str_arr)):
            str_arr[i] = str_arr[i][::-1]
        return " ".join(str_arr)


if __name__ == '__main__':
    solution = Solution()
    print(solution.reverseWords("Let's take LeetCode contest"))
