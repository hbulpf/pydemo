
# hello
name = input('Please enter your name: ')
print(name)

# 变量
a = 5 <= 3 or True
print(a)
a = 10 % 3 + 10 // 3
print(a)
a = 10 % 3 + 10 / 3
print(a)
a = 'ABC'
b = a
a = 'XYZ'
print('a =', a, 'b =', b)


# 条件语句
height = float(input('height: '))
weight = float(input('weight: '))
bmi = weight / height**2
if bmi < 18.5:
    print('过轻')
elif bmi >= 18.5 and bmi < 25:
    print('正常')
elif bmi >= 25 and bmi < 28:
    print('过重')
else:
    print('肥胖')
# 什么都不做
if age >= 18:
    pass


# for循环
sum = 0
for x in range(101):
    sum = sum + x
if sum == 5050:
    print('Gauss is correct.')
else:
    print('Gauss is wrong.')

# while循环
n = 201
pow = 1
while n > 0:
	n = n - 1
	if n % 5 == 0:
		continue
	pow = pow * n
print(pow)


# 进制转换
print(hex(255))
print(hex(1000))