from collections import Counter

c = Counter()
for ch in 'programming':
    c[ch] = c[ch] + 1

print(c)    
# 也可以一次性update
c.update('hello') 
print(c)    
