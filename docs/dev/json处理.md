# json处理

- json: 用于字符串和python数据类型间进行转换
- pickle： 用于python特有的类型和python的数据类型间进行转换

Json模块提供了四个功能：dumps、dump、loads、load

pickle模块提供了四个功能：dumps、dump、loads、load

- dumps把数据类型转换成字符串 
- dump把数据类型转换成字符串并存储在文件中 
- loads把字符串转换成数据类型 
- load把文件打开从字符串转换成数据类型

json是可以在不同语言之间交换数据的，而pickle只在python之间使用。json只能序列化最基本的数据类型，json只能把常用的数据类型序列化（列表、字典、列表、字符串、数字、），比如日期格式、类对象！json就不行了。而pickle可以序列化所有的数据类型，包括类，函数都可以序列化。

## pickle

```
import pickle
d = dict(name='Bob', age=20, score=88)
pickle.dumps(d)
b'\x80\x03}q\x00(X\x03\x00\x00\x00ageq\x01K\x14X\x05\x00\x00\x00scoreq\x02KXX\x04\x00\x00\x00nameq\x03X\x03\x00\x00\x00Bobq\x04u.'
```

`pickle.dumps()`方法把任意对象序列化成一个`bytes`，然后，就可以把这个`bytes`写入文件。或者用另一个方法`pickle.dump()`直接把对象序列化后写入一个file-like Object：

```
f = open('dump.txt', 'wb')
pickle.dump(d, f)
f.close()
```

当我们要把对象从磁盘读到内存时，可以先把内容读到一个`bytes`，然后用`pickle.loads()`方法反序列化出对象，也可以直接用`pickle.load()`方法从一个`file-like Object`中直接反序列化出对象。我们打开另一个Python命令行来反序列化刚才保存的对象：

```
f = open('dump.txt', 'rb')
d = pickle.load(f)
f.close()
{'age': 20, 'score': 88, 'name': 'Bob'}
```

## json

| JSON类型   | Python类型 |
| :--------- | :--------- |
| {}         | dict       |
| []         | list       |
| "string"   | str        |
| 1234.56    | int或float |
| true/false | True/False |
| null       | None       |

### json读写

dumps：将python中的 字典 转换为 字符串

```
import json

test_dict = {'bigberg': [7600, {1: [['iPhone', 6300], ['Bike', 800], ['shirt', 300]]}]}
print(test_dict)
print(type(test_dict))
#dumps 将数据转换成字符串
json_str = json.dumps(test_dict)
print(json_str)
print(type(json_str))
```

loads: 将 字符串 转换为 字典

```
new_dict = json.loads(json_str)
print(new_dict)
print(type(new_dict))
```

dump: 将数据写入json文件中

```
with open("config/record.json","w") as f:
    json.dump(new_dict,f)
    print("写入文件完成...")
```

load: 把文件打开，并把字符串变换为数据类型

```
with open("../config/record.json",'r') as load_f:
     load_dict = json.load(load_f)
     print(load_dict)
load_dict['smallberg'] = [8200,{1:[['Python',81],['shirt',300]]}]
print(load_dict)  
with open("../config/record.json","w") as dump_f:
     json.dump(load_dict,dump_f)
```

### json序列化类

```
import json

class Student(object):
    def __init__(self, name, age, score):
        self.name = name
        self.age = age
        self.score = score

s = Student('Bob', 20, 88)
print(json.dumps(s))
```

运行代码，毫不留情地得到一个`TypeError`：

```
Traceback (most recent call last):
  ...
TypeError: <__main__.Student object at 0x10603cc50> is not JSON serializable
```

错误的原因是`Student`对象不是一个可序列化为JSON的对象。

如果连`class`的实例对象都无法序列化为JSON，这肯定不合理！我们仔细看看`dumps()`方法的参数列表，可以发现，除了第一个必须的`obj`参数外，`dumps()`方法还提供了一大堆的可选参数：https://docs.python.org/3/library/json.html#json.dumps

这些可选参数就是让我们来定制JSON序列化。前面的代码之所以无法把`Student`类实例序列化为JSON，是因为默认情况下，`dumps()`方法不知道如何将`Student`实例变为一个JSON的`{}`对象。

可选参数`default`就是把任意一个对象变成一个可序列为JSON的对象，我们只需要为`Student`专门写一个转换函数，再把函数传进去即可：

```
def student2dict(std):
    return {
        'name': std.name,
        'age': std.age,
        'score': std.score
    }
```

这样，`Student`实例首先被`student2dict()`函数转换成`dict`，然后再被顺利序列化为JSON：

```
>>> print(json.dumps(s, default=student2dict))
{"age": 20, "name": "Bob", "score": 88}
```

不过，下次如果遇到一个`Teacher`类的实例，照样无法序列化为JSON。我们可以偷个懒，把任意`class`的实例变为`dict`：

```
print(json.dumps(s, default=lambda obj: obj.__dict__))
```

因为通常`class`的实例都有一个`__dict__`属性，它就是一个`dict`，用来存储实例变量。也有少数例外，比如定义了`__slots__`的class。

同样的道理，如果我们要把JSON反序列化为一个`Student`对象实例，`loads()`方法首先转换出一个`dict`对象，然后，我们传入的`object_hook`函数负责把`dict`转换为`Student`实例：

```
def dict2student(d):
    return Student(d['name'], d['age'], d['score'])
```

运行结果如下：

```
>>> json_str = '{"age": 20, "score": 88, "name": "Bob"}'
>>> print(json.loads(json_str, object_hook=dict2student))
<__main__.Student object at 0x10cd3c190>
```

打印出的是反序列化的`Student`实例对象。



## 参考

1. [廖雪峰python操作json](https://www.liaoxuefeng.com/wiki/1016959663602400/1017624706151424)

