# -*- coding: utf-8 -*-

# 递归函数
def fact(n):
    if n == 1:
        return 1
    return n * fact(n - 1)
# print("fact(1)=",fact(1))
# print("fact(15)=",fact(15))
# print("fact(100)=",fact(100))
# 报错: RecursionError: maximum recursion depth exceeded in comparison
# fact(1000)


# 尾递归优化
def fact2(n):
    return fact_iter(n, 1)
def fact_iter(num, product):
    if num == 1:
        return product
    return fact_iter(num - 1, num * product)
# print("fact2(1)=",fact2(1))
# print("fact2(15)=",fact2(15))
# print("fact2(100)=",fact2(100))
# 报错: RecursionError: maximum recursion depth exceeded in comparison
# fact(1000)
# print(fact2(1000))


# 汉诺塔
def hanoi(n, a, b, c):
    if n == 1:
        print(a, '-->', c)
    else:
        hanoi(n-1, a, c, b)
        # print(a, '-->', c)
        hanoi(1, a, b, c)
        hanoi(n-1, b, a, c)

# 期待输出:
# A --> C
# A --> B
# C --> B
# A --> C
# B --> A
# B --> C
# A --> C
hanoi(3, 'A', 'B', 'C')
