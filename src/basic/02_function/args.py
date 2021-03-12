# 默认参数
def add_end1(L=[]):
    L.append('END')
    return L

print(add_end1([1,2]))  # [1, 2, 'END']
print(add_end1()) # ['END']
print(add_end1()) # 这里产生了问题 ['END', 'END']

def add_end2(L=None):
    if L is None:
        L = []
    L.append('END')
    return L

print(add_end2([1,2]))  # [1, 2, 'END']
print(add_end2()) # ['END']
print(add_end2()) # 这里产生了问题 ['END', 'END']

def person1(name, age, *args, city, job):
    print(name, age, args, city, job)

# 调用未给出命名关键字 报错：TypeError: person1() missing 2 required keyword-only arguments: 'city' and 'job'
# person1('Jack', 24, 'Male','Beijing', 'Engineer')
# 调用未给出命名关键字 报错：TypeError: person1() missing 2 required keyword-only arguments: 'city' and 'job'
# person1('Jack', 24, 'Beijing', 'Engineer')



# 定义person函数使用 位置参数+默认参数+可变参数+关键字参数+命名关键字参数
def person(a, b=20, *ar, city, job='student', **kw):
	print('name: ', a, 'age:', b, 'birth:', ar, 'city:', city, 'job:', job, 'other:', kw)
# 测试 位置参数+可变参数+关键字参数+命名关键字参数
bir = (98, 7, 16)
inf = {'major': 'maths', 'school': 'zju'}
person('Pan', 20, *bir, city='guangzhou', job='undergra', **inf)

# 测试 位置参数+可变参数+关键字参数+命名关键字参数
inf = {'city': 'guangzhou', 'major': 'maths', 'school': 'zju'}
person('Pan', 20, *bir, **inf)

# 测试 位置参数+可变参数+关键字参数+命名关键字参数
inf = {'city': 'guangzhou', 'job': 'undergra', 'major': 'maths', 'school': 'zju'}
person('Pan', 20, *bir, **inf)

# 测试 位置参数+关键字参数+命名关键字参数
person('Pan', 20, **inf)

# 测试 位置参数+命名关键字参数
person('Pan', 20, city='gz')