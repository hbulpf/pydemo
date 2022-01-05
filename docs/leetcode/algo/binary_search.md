# 二分查找

二分查找的前提是已经排好序。

## 二分查找模板

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