#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/8/17 10:49 下午
@Author: RunAtWorld
@File: CpyExample.py
"""
import copy


def test_cpy():
    my_info = {
        "name": "robot",
        "like": ["human", "dog", "cat"]
    }

    robot1 = copy.copy(my_info)
    robot2 = copy.deepcopy(my_info)
    robot2['like'].append("rabbit")
    robot1['like'].append('jerry')

    print(my_info, "\n", robot1, "\n", robot2)


if __name__ == '__main__':
    test_cpy()
