#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/2 21:13
@Author: RunAtWorld
@File: s.py
"""


def handle(x):
    print("do something")


i = 3


def foo(x):
    def bar():
        return i

    for i in x:
        handle(x)
    return bar()


# i = 3

def foo1(x):
    def bar():
        return i

    y = [i for i in x]
    handle(y)
    return bar()


print("%s %s" % (foo(['x', 'y']), foo1(['x', 'y'])))

print(int('10', 8))
print(int('10', 10))
print(int('10', 16))
print(int('10', 3))
