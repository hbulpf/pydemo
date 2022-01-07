# 二分查找

二分查找的前提是已经排好序。

## 二分查找模板

### 初级-找某个值

> [力扣704. 二分查找](https://leetcode-cn.com/problems/binary-search/)
```python
def binary_search(arr, key):
    left = 0
    right = len(arr) - 1
    while left <= right:
        # 特别注意这里的 <=
        mid = (left + right) // 2
        if arr[mid] < key:
            left = mid + 1
        elif arr[mid] > key:
            right = mid - 1
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
    arr = [4, 2]
    arr.sort()
    print(arr, ":", binary_search(arr, 2))
    print(arr, ":", binary_search(arr, 4))
```


### 中级-找分割点
> [力扣278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)

这种要特别注意边界问题。
```
def firstBadVersion(self, n):
    left = 1
    right = n
    mid = 0
    while left < right:
        # 特别注意这里的 <
        mid = (right + left) // 2
        if isBadVersion(mid):
            # 特别注意这里的 mid，不是mid+1
            right = mid
        else:
            left = mid + 1
    return right
```
找分割点的关键在于: left < right 的时候就要结束循环。不能等 left = right 再结束循环。
由于右边是分割点，因此 right = mid, 不要写成 right = mid + 1。
如果左边是分割点，相应地应该写成 left = mid


## 标准类库

Python 标准模块 `bisect` 中提供了二分查找算法，所以在某些情况下，我们不需要自己来实现。但需注意 bisect 模块查找从下标1开始。

```
from bisect import bisect
arr = [4, 2, 5, 2, 8, 0, -1, 3, 7]
arr.sort()
print(arr, ":", bisect(arr, 5)) 
# [-1, 0, 2, 2, 3, 4, 5, 7, 8] : 7
```

## 连续域的二分查找

这种技术同样可以用在以下情况：函数 f 的区间为连续，且希望找到最小值 x0 ，使得对于所有 x ≥ x0 ，都有 f (x) = 1。此时，时间复杂度取决于 x0 需要的精确度。

```
def continuous_binary_search(f, target, lo, hi):
    while hi - lo > 1e-4:  # 设置精度
        mid = (lo + hi) / 2  # 浮点数除法
        if f(hi) > target:
            hi = mid
        else:
            lo = mid
    return lo
```

测试
```
def test_continuous_binary_search():
    f = lambda x: x ** 2
    print(continuous_binary_search(f, 16, 2.22, 9))
```

## 无上界的连续域查找

## 三分查找

## 在区间 [0, pow(2,k)) 中的查找

## 逆函数

## 力扣题目

填充蓄水池
某个连通容器系统由 n 个瓶壁高度不同的容器互相连通组成，我们想计算将系统的液位提升到一个指定高度所需注入的水量。或者，假设向系统中注入体积为 V 的液体，想确定系统的液面高度，可以使用以下方式

```
level = continuous_binary_search(lambda level: volume(level) >= V, 0, hi)
```