# b表示bytes
print('ABC'.encode('ascii'))
print('ABC'.encode('utf-8'))
print('中文'.encode('utf-8'))
a = b'\xe4\xb8\xad\xff'.decode('utf-8',errors='ignore')
print(a)
print(len(a),len(b'\xe4\xb8\xad'),len('中'.encode('utf-8')))
print('中文测试正常')

# r表示内部字符默认不转义
print(r'seek\t\n\\')
print('''line1
line2
line3''')
print(r'''line1
line2
line3''')
print( """str4
str5
""")


# 字符串格式化
a = 'aging rate: %d%%'
print(a % 3.5)
print('age: %d, name: %s' % (25, '然然'))
print('{0}成绩提升了{1:.2f}%'.format('童童', 5.2316))
# format
str1 = 'my name is {0}, I am {1} years old. Please call me {0}'.format('陈明',12)
print(str1)

print(not '')
