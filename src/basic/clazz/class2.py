#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 使用__slots__
class Student(object):
    pass

s = Student()
s.name = 'Michael' # 动态给实例绑定一个属性
print(s.name)

# 定义一个函数作为实例方法
def set_age(self, age): 
    self.age = age

from types import MethodType
s.set_age = MethodType(set_age, s)
s.set_age(25) # 调用实例方法
print(s.age) # 测试结果    

# 给一个实例绑定的方法，对另一个实例是不起作用的
s2 = Student() # 创建新的实例
# 报错 AttributeError: 'Student' object has no attribute 'set_age'
# s2.set_age(25) # 尝试调用方法


def set_score(self, score):
    self.score = score

Student.set_score = set_score
s.set_score(100)
s2.set_score(99)
print("s1 score:%d , s2 score:%d" % (s.score,s2.score))
s = Student() # 创建新的实例


class Student2(object):
    __slots__ = ('name', 'age') # 用tuple定义允许绑定的属性名称

s = Student2() # 创建新的实例
s.name = 'Michael' # 绑定属性'name'
s.age = 25 # 绑定属性'age'
# 报错AttributeError: 'Student2' object has no attribute 'score'
# s.score = 99 # 绑定属性'score'


# 请利用@property给一个Screen对象加上width和height属性，
# 以及一个只读属性resolution
class Screen(object):
    @property
    def width(self):
        return self.__width

    @width.setter
    def width(self,value):
        self.__width=value
    
    @property
    def height(self):
        return self.__height

    @height.setter
    def height(self,value):
        self.__height=value
    
    @property
    def resolution(self):
        return self.__width * self.__height

# 测试:
s = Screen()
s.width = 1024
s.height = 768
print('resolution =', s.resolution)
if s.resolution == 786432:
    print('测试通过!')
else:
    print('测试失败!')

from enum import Enum

Month = Enum('Month', ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'))    
for name, member in Month.__members__.items():
    print(name, '=>', member, ',', member.value)

from enum import Enum, unique

@unique
class Weekday(Enum):
    Sun = 0 # Sun的value被设定为0
    Mon = 1
    Tue = 2
    Wed = 3
    Thu = 4
    Fri = 5
    Sat = 6

day1 = Weekday.Mon
print(day1)
print(Weekday.Tue)
print(Weekday['Tue'])
print(Weekday.Tue.value)
print(day1 == Weekday.Mon)
print(Weekday(1))


class Gender(Enum):
    Male = 0
    Female = 1

class Student(object):
    def __init__(self, name, gender):
        self.name = name
        self.gender = gender
# 测试:
bart = Student('Bart', Gender.Male)
print('bart gender:',bart.gender)
if bart.gender == Gender.Male:
    print('测试通过!')
else:
    print('测试失败!')