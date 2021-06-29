# -*- coding: utf-8 -*-

def by_name(t):
	return(t[0].lower())

def by_score(t):
    return t[1]

L = [('Bob', 75), ('Adam', 62), ('Bart', 66), ('Lisa', 88)]	
L2 = sorted(L, key=by_name)
print("by_name:",L2)

L3 = sorted(L, key=by_score,reverse=True)
print("by_score:",L3)