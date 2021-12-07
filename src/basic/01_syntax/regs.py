#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/7 22:59
@Author: RunAtWorld
@File: regs.py
@Project: PyCharm
"""
import re


def is_valid_email(addr):
    reg = re.compile(r'^[\w.]+@(\w+\.)+\w+$')
    ok = reg.match(addr)
    print("addr:%s,%s" % (addr, ok))
    return ok


if __name__ == '__main__':
    print(re.split(r'[\s,;]+', 'a,b;; c  d'))
    assert is_valid_email('someone@gmail.com')
    assert is_valid_email('bill.gates@microsoft.com')
    assert not is_valid_email('bob#example.com')
    assert not is_valid_email('mr-bob@example.com')
    print('ok')
