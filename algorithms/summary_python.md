# Python的算法总结

## 队列和栈

python中对于栈和队列的问题，一般可以用 list 和 dequere 来模拟。

list的操作如下

```Python
roommate = ['suhong','ziheng','siyuan'] #创建list
len(roommate) #获取list中元素个数
print(roommate[2]) #取list中元素
print(roommate[-1]) #取list中元素
roommate.append('xinran') #追加元素
roommate.insert(1,'panpan') #指定位置添加元素
roommate.pop() #删除末尾元素
roommate.pop(i) #删除索引i处的元素

roommate.sort() # 对list进行排序,list元素本身顺序发生改变，无返回值
r2=sorted(roommate,reverse=True)  # 对list进行排序,list本身顺序无改变，返回一个新的list
```

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
q
```

`deque` 除了实现list的 `append()` 和 `pop()` 外，还支持 `appendleft()` 和 `popleft()` ，这样就可以非常高效地往头部添加或删除元素。deque 除了从 `collections` 导入，也可以从 `queue` 模块导入。

### 通过 list 实现队列

```python
class MyQueue:
    def __init__(self):
        self._alist=[]

    def put(self,ele):
        self._alist.append(ele)

    def get(self):
        return self._alist.pop(0)

    def size(self):
        return len(self._alist)

    def is_empty(self):
        return not self._alist

    def show(self):
        print(self._alist)

if __name__ == '__main__':
    queue = MyQueue()
    queue.put(1)
    queue.put(4)
    queue.put(6)
    queue.show()
    print(queue.get())
    print(queue.get())
    print(queue.get())
    print(queue.is_empty())
```