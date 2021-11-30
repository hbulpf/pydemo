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
from operator import attrgetter, itemgetter


class Student:

    def __init__(self, name, age, height, chinese, english, math):
        self.name = name
        self.age = age
        self.height = height
        self.chinese = chinese
        self.english = english
        self.math = math

    def __str__(self):
        return "{0:10}{1:6}{2:6}{3:6}{4:6}" \
            .format(self.name, self.height, self.chinese, self.english, self.math)

    def __lt__(self, other):
        return self.height < other.height \
               or (self.height == other.height and self.chinese < other.chinese) \
               or (self.chinese == other.chinese and self.english < other.english) \
               or (self.english == other.english and self.math > other.math) \
               or (self.math == other.math and self.name < other.name)


def cmp_student_attrgetter():
    stus = [
        Student('zhangfei', 33, 181, 81, 72, 72),
        Student('guanyu', 33, 181, 71, 60, 64),
        Student('liubei', 34, 171, 60, 80, 81),
        Student('zhaozilong', 33, 181, 84, 78, 89),
        Student('zhouyu', 33, 181, 84, 72, 72),
        Student('sunquan', 33, 181, 84, 78, 89),
        Student('mayun', 33, 191, 51, 70, 44),
        Student('zhugeliang', 33, 181, 84, 78, 72),
    ]
    stus.sort(key=attrgetter('height', 'chinese', 'english', 'math', 'name'))
    for i in stus:
        print(i)


def cmp_student_lambda():
    stus = [
        Student('zhangfei', 33, 181, 81, 72, 72),
        Student('guanyu', 33, 181, 71, 60, 64),
        Student('liubei', 34, 171, 60, 80, 81),
        Student('zhaozilong', 33, 181, 84, 78, 89),
        Student('zhouyu', 33, 181, 84, 72, 72),
        Student('sunquan', 33, 181, 84, 78, 89),
        Student('mayun', 33, 191, 51, 70, 44),
        Student('zhugeliang', 33, 181, 84, 78, 72),
    ]
    stus.sort(key=lambda x: (x.height, -x.chinese, x.english, -x.math, x.name))
    for i in stus:
        print(i)


def lt_student():
    """
    实现自定义排序
    :return:
    """
    stus = [
        Student('zhangfei', 33, 181, 81, 72, 72),
        Student('guanyu', 33, 181, 71, 60, 64),
        Student('liubei', 34, 171, 60, 80, 81),
        Student('zhaozilong', 133, 181, 84, 78, 89),
        Student('zhouyu', 33, 181, 84, 72, 72),
        Student('sunquan', 33, 181, 84, 78, 89),
        Student('mayun', 33, 191, 51, 70, 44),
        Student('zhugeliang', 33, 181, 84, 78, 72),
    ]
    new_stus = sorted(stus)
    for i in new_stus:
        print(i)

def dict_sort_lambda():
    """
    从小到大排序
    按照每条记录中的'height'排序。如果'height'字段的值相等，
    则按照'chinese'的值排序。
    如果'chinese'依旧相等，则按照'english'排序。
    如果'english'相等，则按照'math'字段的值来排序。
    如果'math'相等，则按照'name'字段的值来排序。
    :return:
    """
    arr = [
        {'name': 'zhangfei', 'height': 181, 'chinese': 81, 'english': 72, 'math': 72},
        {'name': 'zhouyu', 'height': 181, 'chinese': 84, 'english': 72, 'math': 72},
        {'name': 'zhugeliang', 'height': 181, 'chinese': 84, 'english': 78, 'math': 72},
        {'name': 'zhaozilong', 'height': 181, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'liubei', 'height': 171, 'chinese': 60, 'english': 80, 'math': 81},
        {'name': 'sunquan', 'height': 181, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'guanyu', 'height': 181, 'chinese': 71, 'english': 60, 'math': 64},
        {'name': 'mayun', 'height': 191, 'chinese': 51, 'english': 70, 'math': 44}
    ]
    arr.sort(key=lambda x: (x['height'], -x['chinese'], x['english'], -x['math'], x['name']))
    print("{0:10}{1:6}{2:6}{3:6}{4:6}".format('name', 'height', 'chinese', 'english', 'math'))
    for k in arr:
        print("{0:10}{1:6}{2:6}{3:6}{4:6}".format(k['name'], k['height'], k['chinese'], k['english'], k['math']))


def dict_sort_itemgetter():
    arr = [
        {'name': 'zhangfei', 'height': 181, 'chinese': 81, 'english': 72, 'math': 72},
        {'name': 'zhouyu', 'height': 181, 'chinese': 84, 'english': 72, 'math': 72},
        {'name': 'zhugeliang', 'height': 181, 'chinese': 84, 'english': 78, 'math': 72},
        {'name': 'zhaozilong', 'height': 181, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'liubei', 'height': 171, 'chinese': 60, 'english': 80, 'math': 81},
        {'name': 'sunquan', 'height': 181, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'guanyu', 'height': 181, 'chinese': 71, 'english': 60, 'math': 64},
        {'name': 'mayun', 'height': 191, 'chinese': 51, 'english': 70, 'math': 44}
    ]
    sorted(arr,key=itemgetter('height', 'chinese', 'english', 'math', 'name'))
    print("{0:10}{1:6}{2:6}{3:6}{4:6}".format('name', 'height', 'chinese', 'english', 'math'))
    for k in arr:
        print("{0:10}{1:6}{2:6}{3:6}{4:6}".format(k['name'], k['height'], k['chinese'], k['english'], k['math']))


def combine1():
    """聚合"""
    arr = [
        {'name': 'zhangfei', 'height': 181, 'chinese': 81, 'english': 72, 'math': 72},
        {'name': 'zhouyu', 'height': 181, 'chinese': 84, 'english': 72, 'math': 72},
        {'name': 'zhugeliang', 'height': 181, 'chinese': 84, 'english': 78, 'math': 72},
        {'name': 'zhaozilong', 'height': 181, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'liubei', 'height': 171, 'chinese': 60, 'english': 80, 'math': 81},
        {'name': 'sunquan', 'height': 181, 'chinese': 84, 'english': 78, 'math': 89},
        {'name': 'guanyu', 'height': 181, 'chinese': 71, 'english': 60, 'math': 64},
        {'name': 'mayun', 'height': 191, 'chinese': 51, 'english': 70, 'math': 44}
    ]
    grouper = dict()
    for i in arr:
        g_height = str(i['height'])
        grouper.setdefault(g_height, {
            'height': g_height,
            'name': []
        })['name'].append(i['name'])
    print(grouper)


def combine2():
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
    print(m)


def custom_sort_tuple():
    L = [(12, 12), (34, 13), (32, 15), (12, 24), (32, 64), (32, 11)]
    L.sort(key=lambda x: (x[0], -x[1]))
    for i, j in L:
        print(i, j)


def custom_sort_tuple2():
    L = [(12, 12, 22), (34, 13, 43), (32, 15, 22), (12, 24, 17), (32, 64, 98), (32, 11, 34), (32, 11, 4)]
    L.sort(key=lambda x: (x[0], -x[1], -x[1]))
    for i, j, k in L:
        print(i, j, k)


if __name__ == '__main__':
    print("==dict_sort lambda ===")
    dict_sort_lambda()
    print("==dict_sort dict_sort_attrgetter ===")
    dict_sort_itemgetter()
    print("==object cmp_student_attrgetter===")
    cmp_student_attrgetter()
    print("==object cmp_student_lambda===")
    cmp_student_lambda()
    print("==object lt===")
    lt_student()
    print("==combine1===")
    combine1()
    print("==combine2===")
    combine2()
    print("==custom_sort_tuple===")
    custom_sort_tuple()
    print("==custom_sort_tuple2===")
    custom_sort_tuple2()
