import pickle
d = dict(name='Bob', age=20, score=88)
print(pickle.dumps(d))

f = open('dump.txt', 'wb')
pickle.dump(d, f)
f.close()


f = open('dump.txt', 'rb')
d = pickle.load(f)
f.close()