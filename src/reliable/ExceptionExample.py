#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/8/17 11:19 下午
@Author: RunAtWorld
@File: ExceptionExample.py
"""


class ParentException(Exception):
    def __init__(self):
        Exception.__init__(self, "Parent Exception")


class ChildException(ParentException):
    def __init__(self):
        Exception.__init__(self, "Child Exception")


def test_Exception():
    """
    捕获父类异常，子类异常可以正常抛出
    :return:
    """
    try:
        raise ParentException
    except ParentException as e:
        print("catch Exception:%s" % e)
    try:
        raise ChildException
    except ParentException as e:
        print("catch Exception:%s" % e)
    # try:
    #     raise ParentException
    # except ChildException as e:
    #     print("catch Exception:%s" % e)


def test_ret():
    def divide(x, y):
        try:
            return x / y
        except Exception:
            return 0
        finally:
            return -1

    print(divide(1, 0))


def test_ret2():
    def divide(x, y):
        try:
            return x / y
        except ZeroDivisionError:
            raise

    print(divide(1, 0))


if __name__ == '__main__':
    test_Exception()
    test_ret()
    test_ret2()
