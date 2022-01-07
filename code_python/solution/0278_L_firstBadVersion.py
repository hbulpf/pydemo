#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2022/1/7 11:23
@Author: RunAtWorld
@File: 0278_L_firstBadVersion.py
@Project: PyCharm
"""


# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

def isBadVersion(version):
    return version > 3


class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        left = 1
        right = n
        mid = 0
        while left < right:
            mid = (right + left) // 2
            if isBadVersion(mid):
                right = mid
            else:
                left = mid + 1
        return right


if __name__ == '__main__':
    solution = Solution()
    print(solution.firstBadVersion(5))
