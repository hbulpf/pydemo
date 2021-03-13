# -*- coding: utf-8 -*-
# 使用 切片实现 trim，更简洁的方法
def trim(s):
	print("input:",s)
	# 这里不要用 s[0],因为 s[:1]取得的是一个列表，可以为None
	while s[:1]==' ':
		print("res:",s)
		s = s[1:]
	while s[-1:]==' ':
		print("res:",s)
		s = s[:-1]
	return s


# 使用 切片实现 trim, 更高效的方法
def trim2(s):
	i = 0
	if s == '':
		return ''
	while s[i] == ' ':
		i = i + 1
		if i == len(s):
			return ''
	j = len(s) - 1
	while s[j] == ' ':
		j = j - 1
	return s[i:j+1]
	
if trim('hello  ') != 'hello':
    print('测试失败!')
elif trim('  hello') != 'hello':
    print('测试失败!')
elif trim('  hello  ') != 'hello':
    print('测试失败!')
elif trim('  hello  world  ') != 'hello  world':
    print('测试失败!')
elif trim('') != '':
    print('测试失败!')
elif trim('    ') != '':
    print('测试失败!')
else:
    print('测试成功!')