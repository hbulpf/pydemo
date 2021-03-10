import math

def quadratic(a,b,c):
	if not (isinstance(a,(int,float)) and isinstance(b,(int,float)) and isinstance(c,(int,float))):
		raise TypeError('bad operand type')
	delta = b**2 - 4 * a * c
	if delta < 0:
		return 'no real solution'
	else:
		x_1 = (-b + math.sqrt(delta)) / (2 * a)
		x_2 = (-b - math.sqrt(delta)) / (2 * a)
		return x_1, x_2