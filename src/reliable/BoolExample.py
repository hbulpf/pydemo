#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/8/17 10:59 下午
@Author: RunAtWorld
@File: BoolExample.py
"""




def test_is():
    """
    is 用于判断两个变量引用对象是否为同一个， == 用于判断引用变量的值是否相等。
    """
    if ():  # false
        print("1()")
    if []:  # false
        print("2[]")
    if () == ():  # true
        print("1()==()")
    if () is ():  # true
        print("2() is ()")
    if [] == []:  # true
        print("1[] == []")
    if [] is []:  # false
        print("2[] == []")


if __name__ == '__main__':
    test_is()
