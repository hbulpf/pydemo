#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/26 19:57
@Author: RunAtWorld
@File: twoSum.py
"""
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        使用Dict解决
        """
        num_dict = dict()
        for i, v in enumerate(nums):
            tmp = target - v
            if num_dict.get(tmp) is not None:
                # 这里注意 is not None 和 not 是有区别的。not 0 也是false,所以如果只想表示判空，要用 is not None
                return [i, num_dict.get(tmp)]
            else:
                num_dict[v] = i

    def twoSum3(self, nums: List[int], target: int) -> List[int]:
        """
        暴力求解
        """
        res = []
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    res.extend([i, j])
        return res

    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        """
        使用Map解决
        """
        tmp_map = {}
        res = []
        res2 = []
        for i in range(len(nums)):
            tmp_map[target - nums[i]] = nums[i]
        half_flag = 0
        for idx, num in enumerate(nums):
            if tmp_map.get(num) is not None and tmp_map.get(num) + num == target:
                if num * 2 == target:
                    half_flag += 1
                    res2.append(idx)
                else:
                    res.append(idx)
        if half_flag >= 2:
            res.extend(res2)
        return res

    def twoSum1(self, nums: List[int], target: int) -> List[int]:
        tmp_arr = [0] * (target + 1)
        res = []
        res2 = []
        for i in range(len(nums)):
            if nums[i] <= target:
                tmp_arr[target - nums[i]] = nums[i]
        half_flag = 0
        for idx, num in enumerate(nums):
            print(res2)
            if num <= target and tmp_arr[num] + num == target:
                if num * 2 == target:
                    half_flag += 1
                    res2.append(idx)
                else:
                    res.append(idx)
        if half_flag >= 2:
            res.extend(res2)
        return res


if __name__ == '__main__':
    solution = Solution()
    nums = [2, 7, 11, 15]
    target = 9
    print(solution.twoSum(nums, target))  # [0, 1]

    print("---")
    nums = [3, 2, 4]
    target = 6
    print(solution.twoSum(nums, target))  # [1,2]

    print("---")
    nums = [3, 3]
    target = 6
    print(solution.twoSum(nums, target))  # [0,1]

    print("---")
    nums = [0, 4, 3, 0]
    target = 0
    print(solution.twoSum(nums, target))  # [0,3]

    print("---")
    nums = [-3, 4, 3, 90]
    target = 0
    print(solution.twoSum(nums, target))  # [0,3]
