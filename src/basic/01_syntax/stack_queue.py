#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/2 0:05
@Author: RunAtWorld
@File: stack_queue.py
@Project: PyCharm
"""

# 优先级队列
from queue import PriorityQueue

# 实现小顶堆
pq = PriorityQueue()
pq.put(5)
pq.put(7)
pq.put(3)
pq.put(4)
print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))
print(pq.get())  # 3

# 实现大顶堆
pq2 = PriorityQueue()
pq2.put((-5, 5))
pq2.put((-7, 7))
pq2.put((-3, 3))
pq2.put((-4, 4))
print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))
k1, v1 = pq2.get()
print(k1, v1)

# 可以放入对象
pq3 = PriorityQueue()
pq3.put((-5, 5, 'lis'))
pq3.put((-7, 7, 'sx'))
pq3.put((-3, 3, 'sx'))
pq3.put((-4, 4, 'sx'))
print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))
k1, v1, o = pq3.get()
print(k1, v1, o)
