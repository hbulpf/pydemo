#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/9/5 11:17
@Author: RunAtWorld
@File: my_queue.py
"""
import _queue
from queue import Queue, LifoQueue, PriorityQueue

def queue_test():
    # 先进先出队列
    q = Queue(maxsize=5)
    # 后进先出队列
    lq = LifoQueue(maxsize=6)
    # 优先级队列
    pq = PriorityQueue(maxsize=5)

    for i in range(5):
        q.put(i)
        lq.put(i)
        pq.put(i)

    print("先进先出队列：%s;是否为空：%s；多大,%s;是否满,%s" % (q.queue, q.empty(), q.qsize(), q.full()))
    print("后进先出队列：%s;是否为空：%s;多大,%s;是否满,%s" % (lq.queue, lq.empty(), lq.qsize(), lq.full()))
    print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))

    print(q.get(), lq.get(), pq.get())

    print("先进先出队列：%s;是否为空：%s；多大,%s;是否满,%s; done:%s" % (q.queue, q.empty(), q.qsize(), q.full(),q.task_done()))
    print("后进先出队列：%s;是否为空：%s;多大,%s;是否满,%s" % (lq.queue, lq.empty(), lq.qsize(), lq.full()))
    print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))

def multi_process():
    import time, threading
    q = Queue(maxsize=0)

    def product(name):
        count = 1
        while True:
            q.put('气球兵{}'.format(count))
            print('{}训练气球兵{}只'.format(name, count))
            count += 1
            time.sleep(5)

    def consume(name):
        while True:
            print('{}使用了{}'.format(name, q.get()))
            time.sleep(1)
            q.task_done()

    t1 = threading.Thread(target=product, args=('wpp',))
    t2 = threading.Thread(target=consume, args=('ypp',))
    t3 = threading.Thread(target=consume, args=('others',))

    t1.start()
    t2.start()
    t3.start()

def get_bugs():
    import queue
    import time

    q = queue.Queue(10)
    for i in range(100):
        q.put('A',block=True)
        time.sleep(0.1)
    print('write ok')

    while True:
        try:
            data = q.get(block=False)
        except _queue.Empty:
            print('empty')
            break
    print('cosumer ok')

class MyQueue:
    def __init__(self):
        self._alist=[]

    def put(self,ele):
        self._alist.append(ele)

    def get(self):
        return self._alist.pop(0)

    def size(self):
        return len(self._alist)

    def is_empty(self):
        return not self._alist

    def show(self):
        print(self._alist)


if __name__ == '__main__':
    # multi_process()
    # get_bugs()
    queue = MyQueue()
    queue.put(1)
    queue.put(4)
    queue.put(6)
    queue.show()
    print(queue.get())
    print(queue.get())
    print(queue.get())
    print(queue.is_empty())

