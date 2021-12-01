# 常用技巧

## asc码与数字转换

```python
ord('A') #65
chr(65) #A
```

## 比较大小

比较大小，记得用 min() 和 max()

## 进制转换

使用 `int()` / `bin()` / `oct()` / `hex()` 可以实现 十进制、二进制、八进制、十六进制 的转换

```
int(str(110),base=2) #实现2进制到10进制转换,6
bin(15)  #实现10进制到2进制转换,0b1111
oct(255) #实现10进制到2进制转换,0o377
hex(255) #实现10进制到16进制转换,0xff
```

上面进行转换后都多了前缀，如果要去掉前缀，使用下面的方法

```
print(format(-15, '#b'), format(-15, 'b'))
print(format(10, '#o'), format(10, 'o'))
print(format(255, '#x'), format(255, 'X'))
print(int(str(110),base=2))
```

结果为
```
-0b1111 -1111
0o12 12
0xff FF
6
```

## 使用高阶函数简化操作

常用的高阶函数: 
* map()
* reduce()
* filter()
* sorted()

以上高阶函数传入的第1个参数是函数或lambda表达式。

1. 使用 map/reduce 函数实现 str转换为int
```python
from functools import reduce
DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
def char2num(s):
    return DIGITS[s]
def str2int(s):
    # 这里相当于实现一个while循环的累加
    return reduce(lambda x, y: x * 10 + y, map(char2num, s))
```

## 队列

### list模拟队列
用 list 模拟队列，解决一般问题

使用 list 模拟队列
```python
roommate.append('xinran') #入队
a2 = roommate.pop(0) #出队
```

使用 list 模拟栈
```python
roommate.append('xinran') #入栈
a2 = roommate.pop() #出栈
```

### dequeue模拟队列
为了提高效率还可以使用 dequeue。deque是为了高效实现插入和删除操作的双向列表，适合用于队列和栈：

```python
from collections import deque
q = deque(['a', 'b', 'c'])
q.append('x')
q.appendleft('y')
print(q)
a1 = q.pop()
print(a1)
a2 = q.popleft()
print(a2)
```

模拟队列

```Python
q = deque(['a', 'b', 'c'])
q.append('x') #入队
a2 = q.popleft()  #出队
```

模拟栈
```Python
q.append('x') #入栈
a2 = q.pop()  #出栈
```

`deque` 除了实现list的 `append()` 和 `pop()` 外，还支持 `appendleft()` 和 `popleft()` ，这样就可以非常高效地往头部添加或删除元素。deque 除了从 `collections` 导入，也可以从 `queue` 模块导入。

### 优先级队列

优先级队列PriorityQueue在queue包中。 使用优先级队列默认可以实现小顶堆，也可以实现大顶堆。

### 实现小顶堆

```python
# 实现小顶堆
from queue import PriorityQueue
pq = PriorityQueue()
pq.put(5)
pq.put(7)
pq.put(3)
pq.put(4)
print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))
print(pq.get())  # 3
```

### 实现大顶堆

python默认的 pq 是小顶堆实现。 把一个元组 (-x, x) put 进了堆，但是python只会比较元组的第一个元素，即 -x，所以元组的第二位可以用来保存自己的信息

```python
# 实现大顶堆
from queue import PriorityQueue
pq2 = PriorityQueue()
pq2.put((-5, 5))
pq2.put((-7, 7))
pq2.put((-3, 3))
pq2.put((-4, 4))
print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))
k1, v1 = pq2.get()
print(k1, v1)
```

### 实现大顶堆并放入对象

```python
# 可以放入对象
from queue import PriorityQueue
pq3 = PriorityQueue()
pq3.put((-5, 5, 'lis'))
pq3.put((-7, 7, 'sx'))
pq3.put((-3, 3, 'sx'))
pq3.put((-4, 4, 'sx'))
print("优先级队列：%s;是否为空：%s,多大,%s;是否满,%s" % (pq.queue, pq.empty(), pq.qsize(), pq.full()))
k1, v1, o = pq3.get()
print(k1, v1, o)
```

## 自定义排序

1. 进行排序，一般使用 `sort()` 或 `sorted()`。
2. 如果需要降序，设置前面两个函数 `reverse = True`。
3. 对于列表，key 的关键字参数可以实现做某种操作后排序:
    ```python
    sorted([36, 5, -12, 9, -21], key=abs) #结果为[5, 9, -12, -21, 36]
    sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower) #忽略大小写的排序
    ```

4. 如果需要自定义排序，可以对key用用lambda表达式写出排序规则，实现对象的自定义排序
    ```python
    def dict_sort_lambda():
        arr = [
            {'name': 'zhangfei', 'height': 181, 'chinese': 81, 'english': 72, 'math': 72},
            {'name': 'zhouyu', 'height': 181, 'chinese': 84, 'english': 72, 'math': 72},
            {'name': 'zhugeliang', 'height': 181, 'chinese': 84, 'english': 78, 'math': 72},
            {'name': 'guanyu', 'height': 181, 'chinese': 71, 'english': 60, 'math': 64},
            {'name': 'mayun', 'height': 191, 'chinese': 51, 'english': 70, 'math': 44}
        ]
        arr.sort(key=lambda x: (x['height'], -x['chinese'], x['english'], -x['math'], x['name']))
        print("{0:10}{1:6}{2:6}{3:6}{4:6}".format('name', 'height', 'chinese', 'english', 'math'))
        for k in arr:
            print("{0:10}{1:6}{2:6}{3:6}{4:6}".format(k['name'], k['height'], k['chinese'], k['english'], k['math']))
    ```
    
5. 对元组进行自定义排序

    ```
    L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]
    def by_name(t):  
        return t[0].lower()
    def by_score(t):
        #默认排列顺序为从低到高t[1]， 要使其从高到低，将分数先取负数-t[1]即可
        return -t[1]
    L2 = sorted(L, key=by_name)
    print(L2)
    L2 = sorted(L, key=by_score)
    print(L2)

    L2 = sorted(L, key=lambda x: -x[1])
    print(L2)
    ```



## 数据聚合

使用 dict 的 setdefault 函数。 setdefault函数set值后，返回当前key对象的 value **(这是关键)**
```python
def combine2():
    role_list = ([
        {'role_id': 1, 'role_name': 'admin', 'authority': 'create_staff'},
        {'role_id': 1, 'role_name': 'admin', 'authority': 'delete_staff'},
        {'role_id': 1, 'role_name': 'admin', 'authority': 'read_staff'},
        {'role_id': 2, 'role_name': 'manager', 'authority': 'read_staff'},
        {'role_id': 2, 'role_name': 'manager', 'authority': 'delete_staff'},
        {'role_id': 3, 'role_name': 'staff', 'authority': 'read_staff'}
    ])
    m = {}
    for i in role_list:
        rid, rn = str(i['role_id']), i['role_name']
        m.setdefault(rid + rn, {
            'role_id': rid,
            'role_name': rn,
            'authority': []
        })['authority'].append(i['authority'])
    print(m.values())
    print(m)
```

结果为

```
dict_values(
[
{'role_id': '1', 'role_name': 'admin', 'authority': ['create_staff', 'delete_staff', 'read_staff']},
{'role_id': '2', 'role_name': 'manager', 'authority': ['read_staff', 'delete_staff']}, 
{'role_id': '3', 'role_name': 'staff', 'authority': ['read_staff']}
]
)

{
'1admin': {'role_id': '1', 'role_name': 'admin', 'authority': ['create_staff', 'delete_staff', 'read_staff']}, 
'2manager': {'role_id': '2', 'role_name': 'manager', 'authority': ['read_staff', 'delete_staff']}, 
'3staff': {'role_id': '3', 'role_name': 'staff', 'authority': ['read_staff']}
}
```

## 使用推导式

使用推导式移除元素

```python
def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    return [nums1.pop(nums1.index(i)) for i in nums2 if i in nums1]
```