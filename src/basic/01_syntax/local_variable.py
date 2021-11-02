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


print("=====")
if ():
    print(1)
if {}:
    print(2)
if []:
    print(3)
if set():
    print(4)
if 0:
    print(5)

print("=====")
if () is ():
    print(1)
if {} is {}:
    print(2)
if [] is []:
    print(3)
if set() is set():
    print(4)
if '' is '':
    print(5)


print("=====")
if () == ():
    print(1)
if {} == {}:
    print(2)
if [] == []:
    print(3)
if set() == set():
    print(4)
if '' == '':
    print(5)

print("=====")
print(type(()))
print(type({}))
print(type([]))
print(type(set()))
print(type(''))
print(type(0))

print("=====")
print(id(()))
print(id({}))
print(id([]))
print(id(set()))
print(id(''))
print(id(0))

print("=====")
a = ()
b = ()
print(id(a))
print(id(b))

a = ""
b = ''
print(id(a))
print(id(b))

a = []
b = []
print(id(a))
print(id(b))