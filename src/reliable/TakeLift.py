#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
坐电梯
@Time : 2022/1/14 16:10
@Author: RunAtWorld
@File: TakeLift.py
"""
from typing import List


class Solution:

    def take_lift(self, n: int, init_floor: int, nums: List) -> int:
        has_persons = [True] * n
        distance = 0
        last_floor = init_floor
        for i in range(n):
            if has_persons[i]:
                k1, k2 = nums[i]
                distance += self.get_diff(k1, last_floor)
                for j in range(i + 1, n):
                    h1, h2 = nums[j]
                    if k1 > h1 > h2 >= k2 or k1 < h1 < h2 <= k2:
                        has_persons[j] = False
                        print(h1, h2, ":", distance)
                distance += self.get_diff(k1, k2)
                has_persons[i] = False
                last_floor = k2
                print(k1, "=>", k2, ":", distance)
        return distance

    def get_diff(self, v1, v2):
        return max(v1, v2) - min(v1, v2)


if __name__ == '__main__':
    n = 4
    init_floor = 50
    nums = [(50, 10), (40, 20), (30, 50), (40, 50)]
    solution = Solution()
    print(solution.take_lift(n, init_floor, nums))

    print("=====")
    n = 3
    init_floor = 50
    nums = [(50, 10), (30, 100), (30, 100)]
    solution = Solution()
    print(solution.take_lift(n, init_floor, nums))
