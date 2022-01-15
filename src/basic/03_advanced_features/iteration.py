# -*- coding: utf-8 -*-
from collections import Iterable

# 判断一个对象是可迭代对象
print('判断一个对象是可迭代对象')
print(isinstance('abc', Iterable))
print(isinstance([1, 2, 3], Iterable))
print(isinstance(123, Iterable))
print(isinstance({'name': 'Zhang', 'age': 12}, Iterable))
print(isinstance((1, 2, 3), Iterable))

# Python内置的enumerate函数可以把一个list变成索引-元素对
for i, value in enumerate(['A', 'B', 'C']):
    print(i, ':', value)

# 用迭代查找list中的最大值和最小值，并返回两个tuple，分别为最大值及其索引和最小值及其索引
def findMinAndMax(L):
	if not isinstance(L,(list)):
		raise TypeError('请输入一个list')
	if not L:
		return (None,None)
	min = max = L[0]
	max
	for i in L:
		if min > i:
			min = i
		if max < i:
			max = i
	return (min,max)

# 测试
print('findMinAndMax')
if findMinAndMax([]) != (None, None):
    print('测试失败!')
elif findMinAndMax([7]) != (7, 7):
    print('测试失败!')
elif findMinAndMax([7, 1]) != (1, 7):
    print('测试失败!')
elif findMinAndMax([7, 1, 3, 9, 5]) != (1, 9):
    print('测试失败!')
else:
    print('测试成功!')
