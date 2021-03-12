def product(*x):
	if not x:
		raise TypeError('no number')
	pro = 1
	for n in x:
		pro = pro * n;
	return pro

print('product(5) =', product(5))
print('product(5,6,7) =', product(5,6,7))	
print('测试 product() =', product())