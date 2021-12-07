#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/8 1:01
@Author: RunAtWorld
@File: 0002_M_addTwoNumbers.py
@Project: PyCharm
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        l3 = front = ListNode()
        while l1 or l2:
            if (l1 and l1.next) or (l2 and l2.next):
                l3.next = ListNode()
            num1 = l1.val if l1 else 0
            num2 = l2.val if l2 else 0
            sum1 = num1 + num2 + carry
            if sum1 > 9:
                sum1 %= 10
                carry = 1
            else:
                carry = 0
            l3.val = sum1
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            l3 = l3.next
        if carry > 0:
            l3.next = ListNode(1, None)
        return front


if __name__ == '__main__':
    solution = Solution()
