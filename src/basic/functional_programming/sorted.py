def by_name(t):
	return(t[0])

L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]	
L2 = sorted(L, key=by_name)
print(L2)