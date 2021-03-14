# -*- coding: utf-8 -*-
import time, functools

# 定义日志装饰器
def log(func):
    @functools.wraps(func)
    def wrapper(*args,**kw):
        print('call %s():' % func.__name__)
        return func(*args,**kw)
    return wrapper

# 定义带自定义文本的日志装饰器
def log2(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args,**kw):
            print('%s %s():' % (text,func.__name__))
            return func(*args,**kw)
        return wrapper
    return decorator

# 同时支持无文本和自定义文本的日志装饰器
def log3(con):
    if isinstance(con,str):
        def decorator(func):
            @functools.wraps(func)
            def wrapper(*args,**kw):
                print('begin call -> %s %s():' % (con,func.__name__))
                r = func(*args,**kw)
                print('end call -> %s %s():' % (con,func.__name__))
                return r
            return wrapper
        return decorator
    else:
        @functools.wraps(con)
        def wrapper(*args,**kw):
            print('begin call -> %s %s():' % (con,con.__name__))
            r = con(*args,**kw)
            print('end call -> %s %s():' % (con,con.__name__))
            return r
        return wrapper

# 使用装饰器打印
@log
@log3
def now():
    print('2021-3-25')

@log2("执行")
@log3("执行")
def now2():
    print('2021-3-25')

now()
print(now.__name__)
now2()
print(now2.__name__)

def metric(fn):
    @functools.wraps(fn)
    def wrapper(*args,**kw):
        start = time.time()
        r = fn(*args,**kw)
        end = time.time()
        print('%s executed in %s ms' % (fn.__name__, end-start))
        return r
    return wrapper

# 测试
@metric
def fast(x, y):
    time.sleep(0.0012)
    return x + y;

@metric
def slow(x, y, z):
    time.sleep(0.1234)
    return x * y * z;

f = fast(11, 22)
print("fast:",f)
s = slow(11, 22, 33)
print("slow:",s)
if f != 33:
    print('测试失败!')
elif s != 7986:
    print('测试失败!')