#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/8/17 11:54 下午
@Author: RunAtWorld
@File: RegExample.py
"""

if __name__ == '__main__':
    import re

    str = 'www.runoob.com'
    res = re.match('www', str).span()
    print(res)

    print(re.match("com", str))

    res2 = re.search("com", str)
    print(res2.span(), res2.group(), len(res2.groups()), res2)
