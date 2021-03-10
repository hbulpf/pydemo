#用迭代查找list中的最大值和最小值，并返回两个tuple，分别为最大值及其索引和最小值及其索引

def findMinAndMax(s):
	if len(s) == 0:
		print(None)
		return
	min = s[0]
	max = s[0]
	min_index = 0
	max_index = 0
	for i,value in enumerate(s):
		if min > value:
			min = value
			min_index = i
		if max < value:
			max = value
			max_index = i
	print((min_index, min))
	print((max_index, max))
	return

