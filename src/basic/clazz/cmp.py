#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/30 0:41
@Author: RunAtWorld
@File: cmp.py
@Project: PyCharm
python 自定义排序
https://blog.csdn.net/weixin_39776787/article/details/110831530
"""
from operator import attrgetter


class Student:

    def __init__(self, name, age, score, chinese, english, math):
        self.name = name
        self.age = age
        self.score = score
        self.chinese = chinese
        self.english = english
        self.math = math

    def __str__(self):
        return "{0:10}{1:6}{2:6}{3:6}{4:6}" \
            .format(self.name, self.score, self.chinese, self.english, self.math)

    # def __cmp__(self, other):
    #     if self.score != other.score:
    #         return self.score - other.score
    #     elif self.chinese != other.chinese:
    #         return self.chinese - other.chinese
    #     elif self.english != other.english:
    #         return self.english - other.english
    #     elif self.math != other.math:
    #         return self.math - other.math
    #     else:
    #         return self.name - other.name

    def __lt__(self, other):
        if self.score < other.score:
            return self.score < other.score
        elif self.chinese < other.chinese:
            return self.chinese > other.chinese
        elif self.english < other.english:
            return self.english > other.english
        elif self.math < other.math:
            return self.math > other.math
        else:
            return self.name > other.name


def cmp_student():
    stus = [
        Student('zhangfei', 33, 81, 81, 72, 72),
        Student('guanyu', 33, 81, 71, 60, 64),
        Student('liubei', 34, 71, 60, 80, 81),
        Student('zhaozilong', 33, 81, 84, 78, 89),
        Student('zhouyu', 33, 81, 84, 72, 72),
        Student('sunquan', 33, 81, 84, 78, 89),
        Student('mayun', 33, 91, 51, 70, 44),
        Student('zhugeliang', 33, 81, 84, 78, 72),
    ]
    stus.sort(key=attrgetter('score', 'chinese', 'english', 'math', 'name'))
    for i in stus:
        print(i)


def lt_student():
    """
    实现自定义排序
    :return:
    """
    stus = [
        Student('zhangfei', 33, 81, 81, 72, 72),
        Student('guanyu', 33, 81, 71, 60, 64),
        Student('liubei', 34, 71, 60, 80, 81),
        Student('zhaozilong', 33, 81, 84, 78, 89),
        Student('zhouyu', 33, 81, 84, 72, 72),
        Student('sunquan', 33, 81, 84, 78, 89),
        Student('mayun', 33, 91, 51, 70, 44),
        Student('zhugeliang', 33, 81, 84, 78, 72),
    ]
    new_stus = sorted(stus)
    for i in new_stus:
        print(i)


def my_cmp(p1, p2):
    if p1['score'] != p2['score']:
        return p1['score'] - p2['score']
    elif p1['chinese'] != p2['chinese']:
        return p1['chinese'] - p2['chinese']
    elif p1['english'] != p2['english']:
        return p1['english'] - p2['english']
    elif p1['math'] != p2['math']:
        return p1['math'] - p2['math']
    else:
        return p1['name'] - p2['name']


def custorm_sort():
    """
    从小到大排序
    按照每条记录中的'score'排序。如果'score'字段的值相等，
    则按照'chinese'的值排序。
    如果'chinese'依旧相等，则按照'english'排序。
    如果'english'相等，则按照'math'字段的值来排序。
    如果'math'相等，则按照'name'字段的值来排序。
    :return:
    """
    arr = [
        {'name': 'zhangfei', 'score': 81, 'chinese': 81, 'english': 72, 'math': 72},
        {'name': 'zhouyu', 'score': 81, 'chinese': 84, 'english': 72, 'math': 72},
        {'name': 'zhugeliang', 'score': 81, 'chinese': 84, 'english': 78, 'math': 72},
        {'name': 'zhaozilong', 'score': 81, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'liubei', 'score': 71, 'chinese': 60, 'english': 80, 'math': 81},
        {'name': 'sunquan', 'score': 81, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'guanyu', 'score': 81, 'chinese': 71, 'english': 60, 'math': 64},
        {'name': 'mayun', 'score': 91, 'chinese': 51, 'english': 70, 'math': 44}
    ]
    arr.sort(key=lambda x: (x['score'], x['chinese'], x['english'], x['math'], x['name']))
    print("{0:10}{1:6}{2:6}{3:6}{4:6}".format('name', 'score', 'chinese', 'english', 'math'))
    for k in arr:
        print("{0:10}{1:6}{2:6}{3:6}{4:6}".format(k['name'], k['score'], k['chinese'], k['english'], k['math']))
        # print("{0},33,{1},{2},{3},{4}".format(k['name'], k['score'], k['chinese'], k['english'], k['math']))
    # new_arr = sorted(arr, key=cmp)

    # 聚合
    grouper = dict()
    for i in arr:
        g_score = str(i['score'])
        grouper.setdefault(g_score, {
            'score': g_score,
            'name': []
        })['name'].append(i['name'])
    print(grouper)


def combine():
    """
    https://segmentfault.com/q/1010000022099086
    聚合为
    new_role_list = ([
                  {role_id: 1, role_name: 'admin', 'authority': ['create_staff','delete_staff','read_staff']},
                  {role_id: 2, role_name: 'manager', 'authority': ['read_staff','delete_staff']},
                  {role_id: 3, role_name: 'staff', 'authority': ['read_staff']}
            ])
    :return:
    """
    # 聚合
    role_list = ([
        {'role_id': 1, 'role_name': 'admin', 'authority': 'create_staff'},
        {'role_id': 1, 'role_name': 'admin', 'authority': 'delete_staff'},
        {'role_id': 1, 'role_name': 'admin', 'authority': 'read_staff'},
        {'role_id': 2, 'role_name': 'manager', 'authority': 'read_staff'},
        {'role_id': 2, 'role_name': 'manager', 'authority': 'delete_staff'},
        {'role_id': 3, 'role_name': 'staff', 'authority': 'read_staff'}
    ])
    m = {}
    for i in role_list:
        rid, rn = str(i['role_id']), i['role_name']
        m.setdefault(rid + rn, {
            'role_id': rid,
            'role_name': rn,
            'authority': []
        })['authority'].append(i['authority'])
    print(m.values())


if __name__ == '__main__':
    custorm_sort()
    print("==cmp===")
    cmp_student()
    print("==lt===")
    lt_student()
    print("==lt===")
    combine()
