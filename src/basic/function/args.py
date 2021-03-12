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

# 下面调用未给出命名关键字 报错：TypeError: person1() missing 2 required keyword-only arguments: 'city' and 'job'
# person1('Jack', 24, 'Male','Beijing', 'Engineer')
# 下面调用未给出命名关键字 报错：TypeError: person1() missing 2 required keyword-only arguments: 'city' and 'job'
# person1('Jack', 24, 'Beijing', 'Engineer')

def person(a, b=20, *ar, city, job='student', **kw):
	print('name: ', a, 'age:', b, 'birth:', ar, 'city:', city, 'job:', job, 'other:', kw)

bir = (98, 7, 16)
inf = {'major': 'maths', 'school': 'zju'}
person('Pan', 20, *bir, city='guangzhou', job='undergra', **inf)

inf = {'city': 'guangzhou', 'major': 'maths', 'school': 'zju'}
person('Pan', 20, *bir, **inf)

inf = {'city': 'guangzhou', 'job': 'undergra', 'major': 'maths', 'school': 'zju'}
person('Pan', 20, *bir, **inf)

person('Pan', 20, **inf)

person('Pan', 20, city='gz')