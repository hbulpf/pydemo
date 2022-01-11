#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2022/1/12 0:26
@Author: RunAtWorld
@File: 0876_L_middleNode.py
@Project: PyCharm
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        """
        快慢指针法
        """
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow


if __name__ == '__main__':
    n5 = ListNode(5)
    n4 = ListNode(4, n5)
    n3 = ListNode(3, n4)
    n2 = ListNode(2, n3)
    n1 = ListNode(1, n2)
    solution = Solution()
    target = solution.middleNode(n1)
    print(target.val)
