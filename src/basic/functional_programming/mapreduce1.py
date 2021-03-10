def normalize(name):
	def cap(s):
		return s.capitalize()
	return list(map(cap, name))
	
L1 = ['adam', 'Lisa', 'barT']
print(normalize(L1))