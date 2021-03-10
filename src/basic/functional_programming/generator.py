def triangle(n):
	if n == 0:
		yield []
	L = [1]
	while len(L) <= n:
		yield L
		t = L.copy()
		for i in range(1,len(t)):
			L[i] = t[i-1] + t[i]
		L.append(1)
		
for tri in triangle(0):
	print(tri)