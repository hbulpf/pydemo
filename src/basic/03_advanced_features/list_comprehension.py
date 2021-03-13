# -*- coding: utf-8 -*-

import os

print(list(range(1, 11)))

L = []
for x in range(1, 11):
    L.append(x * x)
print(L)

# 列表生成式
L1 = [x * x for x in range(1, 11)]
print(L1)

# 筛选出偶数的平方
L2 = [x * x for x in range(1, 11) if x % 2 == 0]
print(L2)

# 使用两层循环
L3 = [m + n for m in 'ABC' for n in 'XYZ']
print(L3)

# 列出文件和目录
L4 = [d for d in os.listdir('.')]
print(L4)

# 列表生成式也可以使用两个变量来生成list
d = {'x': 'A', 'y': 'B', 'z': 'C'}
L5 = [(k, v) for k, v in d.items()]
print(L5)

# 把一个list中所有的字符串变成小写
L = ['Hello', 'World', 'IBM', 'Apple']
L6 = [s.lower() for s in L]
print(L6)

# for前面的if ... else是表达式，而for后面的if是过滤条件，不能带else
L7 = [x if x % 2 == 0 else -x for x in range(1, 11)]
print(L7)

L1 = ['Hello', 'World', 18, 'Apple', None]
L2 = [s.lower() for s in L1 if isinstance(s, str)]
print(L8)
