#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/2 11:45
@Author: RunAtWorld
@File: H458_poorPigs.py
"""


class Solution:
    def poorPigs(self, buckets: int, minutesToDie: int, minutesToTest: int) -> int:
        base = minutesToTest // minutesToDie + 1
        from math import ceil, log
        return ceil(log(buckets) / log(base))


if __name__ == '__main__':
    solution = Solution()
    print(solution.poorPigs(1000, 15, 60))
    print(solution.poorPigs(1000, 15, 15))
