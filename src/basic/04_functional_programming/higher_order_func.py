# -*- coding: utf-8 -*-

def doublepow(n):
	l = list((range(1,n+1)))
	p = 1
	for x in l[::-2]:
		p = p * x
	return p

def fun(x, y, f):
	return f(x) + f(y)

print(fun(5,4,doublepow))