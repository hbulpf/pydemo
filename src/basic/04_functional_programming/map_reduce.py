# -*- coding: utf-8 -*-

from functools import reduce

# 利用map()函数，把用户输入的不规范的英文名字，变为首字母大写，其他小写的规范名字。
# 输入：['adam', 'LISA', 'barT']，输出：['Adam', 'Lisa', 'Bart']
def normalize(name):
    # return name.capitalize()
    return name.title()
# 测试:
L1 = ['adam', 'LISA', 'barT']
L2 = list(map(normalize, L1))
print("L2:",L2)

# 请编写一个prod()函数，可以接受一个list并利用reduce()求积：
def prod(L):
    def mul(x, y):
        return x * y
    return reduce(mul, L)
# 测试:
print('3 * 5 * 7 * 9 =', prod([3, 5, 7, 9]))
if prod([3, 5, 7, 9]) == 945:
    print('测试成功!')
else:
    print('测试失败!')


# 利用map和reduce编写一个str2float函数，把字符串'123.456'转换成浮点数123.456
DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4,
          '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
def str2float1(s):
    k = s.find('.')
    def f1(x, y):
        return 10 * x + y
    def f2(x, y):
        return x / 10 + y
    def char2num(s):
        return DIGITS[s]
    return reduce(f1, map(char2num, s[0:k])) + reduce(f2, map(char2num, s[:k:-1]))/10

def str2float(s):
    s2 = s.split('.')
    def char2num(num):
        return DIGITS[num]
    def fn(x,y):
        return x*10+y
    return reduce(fn,map(char2num,s2[0]))+reduce(fn,map(char2num,s2[1]))*(10**-len(s2[1]))

print('str2float(\'123.456\') =', str2float('123.456'))
if abs(str2float('123.456') - 123.456) < 0.00001:
    print('测试成功!')
else:
    print('测试失败!')



