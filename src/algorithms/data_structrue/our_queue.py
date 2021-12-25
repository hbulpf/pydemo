#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/26 0:19
@Author: RunAtWorld
@File: OurQueue.py
@Project: PyCharm
"""


class OurQueue:
    """
    使用栈模拟双端队列
    从in_stack进入,从out_stack出
    """

    def __init__(self):
        self.__in_stack = list()
        self.__out_stack = list()

    def __len__(self):
        return len(self.__in_stack) + len(self.__out_stack)

    def push(self, obj):
        self.__in_stack.append(obj)

    def pop(self):
        if not self.__out_stack:
            self.__out_stack = self.__in_stack[::-1]
            self.__in_stack = []
        return self.__out_stack.pop()


if __name__ == '__main__':
    q = OurQueue()
    q.push(3)
    q.push(4)
    q.push(5)
    q.push(2)
    q.push(1)
    while len(q) > 0:
        print(q.pop())
