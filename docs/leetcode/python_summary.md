# Python算法总结

## 一些注意

### 初始化矩阵
下面代码生成一个所有行完全相同的矩阵M，而M[0][0]的修改会导致第一列所有元素都被修改。 
```
M = [[0] * 5] * 5
```

正确的初始化方式如下
```
M = [[0] * 5 for _ in range(5)]
M = [[0 for _ in range(5)] for _ in range(5)]
```


## 进制与位运算

### 位运算

#### 异或

规律
- 基本规律: `a^a = 0 ;0^a = a`
- 交换律 `a^b=b^a; a^b^a = a^a^b = b`

1. 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
   ```
    def singleNumber(self, nums: List[int]) -> int:
        """
        题目的关键是其余每个元素均出现两次
        异或运算: a^a = 0 ;0^a = a
        异或运算 满足交换律 a^b^a = a^a^b = b
        """
        reduct = 0
        for i in nums:
            reduct ^= i
        return reduct
   ```

## 基础数据结构

### 字符串(字典树)

### 线性表

字符数组、静态数组、动态数组、链表

#### 链表

1. 链表操作时注意判空。
2. 链表有指针，返回元素指针时，不一定是返回头节点的指针。

### 哈希/Map

### 队列和栈

在 Python 的标准库中，有两个类实现了队列。第一是 Queue 类，这是一个同步实现，意味着多个进程可以同时访问同一个对象,主要实现并发机制, 它在执行同步的时候使用的信号机制会拖慢执行速度。第二是 Deque 类（Double EndedQueue，即双向队列），除了提供标准方法，即在尾部使用append(element) 添加元素和在头部使用 popleft() 提取元素之外，它还提供了额外方法，用于在队列头部使用 appendleft(element) 添加元素和在尾部使用 pop() 提取元素。

#### list和dequere

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

使用 list 模拟队列
```Python
roommate.append('xinran') #入队
a2 = roommate.pop(0) #出队
```

使用 list 模拟栈
```Python
roommate.append('xinran') #入栈
a2 = roommate.pop() #出栈
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

#### 通过 list 实现队列

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

### 树

二叉树、二叉查找树、二叉平衡树、哈夫曼树、红黑树、B树

### 堆

堆（heap）是一个能检查元素优先级的反转树状结构。假如每个节点的键值（也就是优先级）比其子节点小，那这就是一个最小堆。最小堆根节点的键值一定是堆中最小的一个。同样也存在最大堆的概念，即每个节点的键值都比其所有子节点的键值要大。

#### 优先队列

在 Python 语言中，堆排列是用 heapq 模块实现的。这个模块提供了把数组转化成堆的方法，即 heapify(table)。

### 图



## 基本算法

### 排序与查找

### 枚举

遍历(暴力枚举)、排列、组合，有时要用二分法

### 指针

滑动窗口、双指针、前缀和

### 递归与迭代

### 回溯

### 分治(归并和二分)

归并和二分

#### 二分查找

二分查找的前提是已经排好序。

二分查找算法模板
```python
def binary_search(arr, key):
    left = 0
    right = len(arr) - 1
    while left <= right:
        # 特别注意这里的 <=
        mid = (left + right) // 2
        if arr[mid] < key:
            left = mid
        elif arr[mid] > key:
            right = mid
        else:
            return mid
    return -1
```
测试
```python
def test1():
    arr = [4, 2, 5, 2, 8, 0, -1, 3, 7]
    arr.sort()
    print(arr, ":", binary_search(arr, 5))
    print(arr, ":", binary_search(arr, 2))
```

### 搜索

深度搜索、广度搜索

### 贪心

### 动态规划

## 系统设计

## 一些心得

1. 线下练习不要着急看题解，否则会过分依赖题解。先自己做，实在无法完成再看题解。
2. 正确的审题是成功的一半，明确输入输出。
3. 考试时部分用例错误不会具体报哪个用例错误，也不会给控制台中的输入提供正确答案。**需要自己设计用例并确认用例输出。** 这就要求自己能根据输入输出关系做等价类划分，考虑非法和异常的场景。