# dictionary 字典
ad = {'mar': 13, (1, 2): 55, 'wat': 67}
ad['hap'] = 23
print(ad)
print(ad['wat'])
print(ad.get('pap'))
print(ad.get('pap', 1))
print(ad)
ad.pop('mar')
ext = dict({'three': 3, 'one': 1, 'two': 2})
print(ad)
ad.update(ext)
print(f"add ext:{ad}")

# set 集合
s = set([2, 2, 3, (1, 2), 5])
print(s)
s.add(4)
print(s)
s.remove(4)
print(s)
se = set([5, 2, (2, 3)])
print(se & s)
print(se | s)

# list 列表
roommate = ['suhong', 'ziheng', 'siyuan']
print(roommate[2])
roommate.append('xinran')
print(roommate)
roommate.pop()
print(roommate)
roommate.insert(1, ['panpan', 'xinran'])
print(roommate)
print(roommate[1][1])
print(roommate[-2])
print(len(roommate))

# tuple 元组
she = ('suhong',)
print(she)
she1 = ('suhong')
print(she1)
she2 = ()
print(she2)
roommate = ('suhong', 'siyuan', ['panpan', 'ziheng'])
print(roommate)
roommate[2][1] = 'bianbian'
print(roommate)
print(len(roommate))

print([i for i in range(10)])


L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]
def by_name(t):
    return t[0].lower()
def by_score(t):
    #默认排列顺序为从低到高t[1]， 要使其从高到低，将分数先取负数-t[1]即可
    return -t[1]
L2 = sorted(L, key=by_name)
print(L2)
L2 = sorted(L, key=by_score)
print(L2)
L2 = sorted(L, key=lambda x: -x[1])
print(L2)
