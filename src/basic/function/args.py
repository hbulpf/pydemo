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