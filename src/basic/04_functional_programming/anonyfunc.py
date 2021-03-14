def build(x, y):
    return lambda x, y: x * x + y * y


def build1(x, y):
    return lambda: x * x + y * y


f = build(2, 3)
f1 = build1(2, 3)
print(f(1, 2))
print(f1())

L = list(filter(lambda n: n % 2 == 1, range(1, 20)))
print(L)


def is_odd(n):
    return n % 2 == 1

L1 = list(filter(is_odd, range(1, 20)))
print("L1:", L1)
print("L2:", list(filter(lambda x: x % 2 == 1, range(1, 20))))
