# -*- coding: utf-8 -*-

L = [x * x for x in range(10)]
print(L)

g = (x * x for x in range(10))
print(g)
for i in range(0,10):
    print(next(g))

# 斐波拉契函数
def fib1(max):
    n, a, b = 0, 0, 1
    while n < max:
        print(b)
        a, b = b, a + b
        n = n + 1
    return 'done'
fib1(10)

# 定义generator计算斐波拉契函数
def fib2(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'
L=fib2(10)
for n1 in L:
    print(n1)

# 是用for循环调用generator时，发现拿不到generator的return语句的返回值。如果想要拿到返回值，必须捕获StopIteration错误，返回值包含在StopIteration的value中
g = fib2(6)
while True:
    try:
        x = next(g)
        print('g:', x)
    except StopIteration as e:
        print('Generator return value:', e.value)
        break

# 杨辉三角
def triangles1():
    res = []
    res.append([1])
    for i in range(1,10):
        L = [1]
        for j in range(1,i):
            L.append(res[i-1][j-1]+res[i-1][j])
        L.append(1)
        res.append(L)
    return res

# 使用 generator,我的解
def triangles2():
    L1=[1]
    for i in range(1,11):
        yield L1
        L2 = [1]
        for j in range(1,i):
            L2.append(L1[j-1]+L1[j])
        L2.append(1)
        L1 = L2
    return 'done'

# 使用 generator,更好的解
def triangles():
    L = [1]
    while True:
        yield L[:]
        # 杨辉三角相当于前后补0
        L.append(0)
        L=[L[n-1]+L[n] for n in range(len(L))]

# 期待输出:
# [1]
# [1, 1]
# [1, 2, 1]
# [1, 3, 3, 1]
# [1, 4, 6, 4, 1]
# [1, 5, 10, 10, 5, 1]
# [1, 6, 15, 20, 15, 6, 1]
# [1, 7, 21, 35, 35, 21, 7, 1]
# [1, 8, 28, 56, 70, 56, 28, 8, 1]
# [1, 9, 36, 84, 126, 126, 84, 36, 9, 1]
n = 0
results = []
for t in triangles():
    results.append(t)
    n = n + 1
    if n == 10:
        break

for t in results:
    print(t)

if results == [
    [1],
    [1, 1],
    [1, 2, 1],
    [1, 3, 3, 1],
    [1, 4, 6, 4, 1],
    [1, 5, 10, 10, 5, 1],
    [1, 6, 15, 20, 15, 6, 1],
    [1, 7, 21, 35, 35, 21, 7, 1],
    [1, 8, 28, 56, 70, 56, 28, 8, 1],
    [1, 9, 36, 84, 126, 126, 84, 36, 9, 1]
]:
    print('测试通过!')
else:
    print('测试失败!')