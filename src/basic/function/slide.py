def trim(s):
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