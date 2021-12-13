#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
剑指 Offer 40. 最小的k个数
@Time : 2021/12/13 19:27
@Author: RunAtWorld
@File: 40_getLeastNumbers.py
"""
import random
from typing import List
from queue import PriorityQueue


class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        """
        采用分治法，类似于快速排序，只排其中一边
        :param arr:
        :param k:
        :return:
        """
        if k < 1:
            return []
        if k > len(arr):
            return arr
        idx = self.selected_partation(arr, 0, len(arr) - 1, k)
        return arr[:idx + 1]

    def selected_partation(self, arr, left, right, k):
        idx = self.random_selected_partation(arr, left, right)
        if idx == left + k - 1:
            return idx
        elif idx < left + k - 1:
            return self.selected_partation(arr, idx + 1, right, k - idx + left -1)
        else:
            return self.selected_partation(arr, left, idx - 1, k)

    def random_selected_partation(self, arr, left, right):
        import random
        rand = random.randint(left, right)
        arr[rand], arr[right] = arr[right], arr[rand]
        return self.partation(arr, left, right)

    def partation(self, arr, left, right):
        pivot = arr[right]
        while left < right:
            while left < right and arr[left] < pivot:
                left += 1
            arr[right] = arr[left]
            while left < right and arr[right] >= pivot:
                right -= 1
            arr[left] = arr[right]
        arr[left] = pivot
        return left

    def getLeastNumbers2(self, arr: List[int], k: int) -> List[int]:
        """
        使用优先级队列模拟大根堆
        时间 O(N * lgK)
        空间 O(lgK)
        :param arr:
        :param k:
        :return:
        """
        if k < 1:
            return []
        if k > len(arr):
            return arr

        from queue import PriorityQueue
        pq = PriorityQueue(k)
        for _, v in enumerate(arr):
            if pq.full():
                top = pq.get()[1]
                ele = top if top < v else v
                pq.put((-ele, ele))
            else:
                pq.put((-v, v))
        res = list()
        while not pq.empty():
            res.append(pq.get()[1])
        return res

    def getLeastNumbers1(self, arr: List[int], k: int) -> List[int]:
        arr.sort()
        return arr[:k]


if __name__ == '__main__':
    solution = Solution()
    arr = [3, 2, 1]
    print(solution.getLeastNumbers(arr, 2))

    arr = [0, 0, 1, 2, 4, 2, 2, 3, 1, 4]
    print(solution.getLeastNumbers(arr, 8))

    arr = [0, 0, 0, 2, 0, 5]
    print(solution.getLeastNumbers(arr, 0))

"""
[2, 1]
[3, 2, 2, 2, 1, 1, 0, 0]

[1, 2]
[0, 0, 1, 2, 1, 2, 2, 3]
"""
