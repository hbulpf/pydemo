#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
19. 删除链表的倒数第 N 个结点

这道题是否考验编程技巧
a. 直接这道题: 难点在于临界值的选择控制。这种通常不好找(也能找)。尤其是当需要删除的接点是head时更难处理。
b. 构造一个虚拟的头节点dummy,代替head。这是一个比较好的思路:
    使快指针走到 n+1的位置，这样与慢节点就相差 n+1个节点;
    快节点走到最后，即 len+1位置，慢节点走到 len-n 位置，即倒数第n个节点前一个。

@Time : 2022/1/14 21:56
@Author: RunAtWorld
@File: 0019_M_removeNthFromEnd.py
@Project: PyCharm
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 构造一个伪头节点
        dummy = ListNode(0, head)
        slow = dummy
        fast = head
        # 使快指针走到 n+1的位置，这样与慢节点就相差 n+1个节点
        for i in range(n):
            fast = fast.next
        while fast:
            # 快节点走到最后，即 len+1位置，慢节点走到 len-n 位置，即倒数第n个节点前一个
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        return dummy.next

    def removeNthFromEnd2(self, head: ListNode, n: int) -> ListNode:
        slow = fast = head
        i = 0
        cnt = 0
        while fast:
            if i >= n + 1:
                slow = slow.next
            fast = fast.next
            i += 1
            cnt += 1
        if slow == head and cnt == n:
            head = slow.next
            return head
        if slow.next:
            slow.next = slow.next.next
        return head


if __name__ == '__main__':
    ans = []
    solution = Solution()

    mocker = [1, 2, 3, 4, 5]
    nodes = [ListNode(i, None) for i in mocker]
    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]
    tail = solution.removeNthFromEnd(nodes[0], 2)
    while tail:
        ans.append(tail.val)
        tail = tail.next
    print(ans)

    ans.clear()
    node = ListNode(1, None)
    tail = solution.removeNthFromEnd(node, 1)
    while tail:
        ans.append(tail.val)
        tail = tail.next
    print(ans)

    ans.clear()
    mocker = [1, 2]
    nodes = [ListNode(i, None) for i in mocker]
    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]
    tail = solution.removeNthFromEnd(nodes[0], 1)
    while tail:
        ans.append(tail.val)
        tail = tail.next
    print(ans)

    ans.clear()
    mocker = [1, 2]
    nodes = [ListNode(i, None) for i in mocker]
    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]
    tail = solution.removeNthFromEnd(nodes[0], 2)
    while tail:
        ans.append(tail.val)
        tail = tail.next
    print(ans)
