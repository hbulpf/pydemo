# 并查集

## 实现

```
class UnionFind:
    """
    并查集
    """

    def __init__(self, n):
        self.__parents = list(range(n))
        self.__rank = [1] * n

    def find(self, x):
        if self.__parents[x] == x:
            return x
        else:
            self.__parents[x] = self.find(self.__parents[x])
            return self.__parents[x]

    def union(self, x, y):
        x_root = self.find(x)
        y_root = self.find(y)
        if x_root == y_root:
            # 已经在同一集合中
            return False

        if self.__rank[x_root] <= self.__rank[y_root]:
            small = x_root
            large = y_root
        else:
            small = y_root
            large = x_root
        self.__parents[small] = large

        if self.__rank[small] == self.__rank[large]:
            self.__rank[large] += 1
        return True
```

## 参考

1. [知乎: 算法学习笔记(1) : 并查集](https://zhuanlan.zhihu.com/p/93647900)
2. [维基百科:并查集](https://zh.wikipedia.org/zh-hans/%E5%B9%B6%E6%9F%A5%E9%9B%86)