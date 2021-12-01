# b表示bytes
print('ABC'.encode('ascii'))
print('ABC'.encode('utf-8'))
print('中文'.encode('utf-8'))
a = b'\xe4\xb8\xad\xff'.decode('utf-8', errors='ignore')
print(a)
print(len(a), len(b'\xe4\xb8\xad'), len('中'.encode('utf-8')))
print('中文测试正常')

# r表示内部字符默认不转义
print(r'seek\t\n\\')
print('''line1
line2
line3''')
print(r'''line1
line2
line3''')
print("""str4
str5
""")

# 字符串格式化
a = 'aging rate: %d%%'
print(a % 3.5)
print('age: %d, name: %s' % (25, '然然'))
print('{0}成绩提升了{1:.2f}%'.format('童童', 5.2316))
# format
str1 = 'my name is {0}, I am {1} years old. Please call me {0}'.format('陈明', 12)
print(str1)

print(not '')

pic_path = 'reqs/unet.jpg'
idx = pic_path.rfind('.')
print(idx)
name = pic_path[:idx - 1] + '-tmp' + pic_path[idx:]
print(name)

idx = pic_path.rfind('/')
print('rsps/' + 'boxed-' + pic_path[idx + 1:])

for i in range(3):
    nums = []
    print(nums)
    for j in range(3):
        nums.append(j)
    print(nums)

print("-----")
print(int(str(110), base=2))  # 实现2进制到10进制转换
print(bin(15))  # 实现10进制到2进制转换
print(oct(255))  # 实现10进制到2进制转换
print(hex(255)) # 实现10进制到16进制转换

print("-----")
print(format(-15, '#b'), format(-15, 'b'))
print(format(10, '#o'), format(10, 'o'))
print(format(255, '#x'), format(255, 'X'))
print(int(str(110),base=2))
