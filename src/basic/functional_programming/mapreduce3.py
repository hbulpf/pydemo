from functools import reduce

DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}

def str2float(s):
	k = 0
	for i in s:
		if i == '.':
			break
		k = k + 1
	def f1(x, y):
		return 10 * x + y
	def f2(x, y):
		return x / 10 + y
	def char2num(s):
		return DIGITS[s]
	return reduce(f1, map(char2num, s[0:k])) + reduce(f2, map(char2num, s[:k:-1]))/10
	
print('str2float(\'123.456\') =', str2float('123.456'))
if abs(str2float('123.456') - 123.456) < 0.00001:
    print('测试成功!')
else:
    print('测试失败!')