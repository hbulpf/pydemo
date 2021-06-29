#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 类例子
class Student1(object):

	def __init__(self, name, score):
		self.name = name
		self.score = score
	
	def print_score(self):
		print('%s: %s' % (self.name, self.score))
	
	def get_grade(self):
		if self.score >= 90:
			return 'A'
		elif self.score >= 60:
			return 'B'
		else:
			return 'C'
	
	def print_grade(self):
		print('%s: %s' % (self.name, self.get_grade()))

lisa = Student1('Lisa', 99)
bart = Student1('Bart', 59)
print(lisa.name, lisa.get_grade())
print(bart.name, bart.get_grade())

# 私有的方法和成员变量
class Student2(object):
	
	def __init__(self, name, gender):
		self.name = name
		self.__gender = gender
	
	def get_gender(self):
		return self.__gender
		
	def set_gender(self, gender):
		self.__gender = gender
	
	# 私有的方法和成员变量都不能在类外使用
	def __print(self):
		print('%s: %s' % (self.name, self.__gender))		

lisa = Student2('Lisa', 'Female')
bart = Student2('Bart', 'Male')
print(lisa.name, lisa.get_gender())
# 私有的方法和成员变量都不能在类外使用,但可以通过这种方式调用
lisa._Student2__print()
print(bart.name, bart.get_gender())

# 类属性
class Student(object):
	count = 0
	
	def __init__(self, name):
		self.name = name
		Student.count += 1				
# 测试:
if Student.count != 0:
    print('测试失败!')
else:
    bart = Student('Bart')
    if Student.count != 1:
        print('测试失败!')
    else:
        lisa = Student('Bart')
        if Student.count != 2:
            print('测试失败!')
        else:
            print('Students:', Student.count)
            print('测试通过!')	