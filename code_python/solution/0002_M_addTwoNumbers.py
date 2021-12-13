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
        """
        返回链表的指针，也未必一定要返回链表的头，返回链表的中间某个元素的指针也可以
        """
        carry = 0
        tail = front = ListNode(-1)
        while l1 or l2:
            num1 = l1.val if l1 else 0
            num2 = l2.val if l2 else 0
            sum1 = num1 + num2 + carry
            carry = sum1 // 10
            sum1 %= 10
            tail.next = ListNode(sum1)
            tail = tail.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        if carry > 0:
            tail.next = ListNode(1)
        return front.next


    def addTwoNumbers1(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
        两数相加，采用模拟方法
        只是需要特别注意 对链表元素为空的判断
        """
        carry = 0
        tail = front = None
        while l1 or l2:
            num1 = l1.val if l1 else 0
            num2 = l2.val if l2 else 0
            sum1 = num1 + num2 + carry
            carry = sum1 // 10
            sum1 %= 10
            if not front:
                tail = front = ListNode(sum1)
            else:
                tail.next = ListNode(sum1)
                tail = tail.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        if carry > 0:
            tail.next = ListNode(1)
        return front


if __name__ == '__main__':
    solution = Solution()
    print('hi')