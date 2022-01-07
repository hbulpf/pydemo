# 堆与优先级队列

## 堆

堆（heap）是一个能检查元素优先级的反转树状结构。假如每个节点的键值（也就是优先级）比其子节点小，那这就是一个最小堆。最小堆根节点的键值一定是堆中最小的一个。同样也存在最大堆的概念，即每个节点的键值都比其所有子节点的键值要大。

在 Python 语言中，堆排列是用 heapq 模块实现的。这个模块提供了把数组转化成堆的方法，即 heapify(table)。这个模块同样可以插入一个新元素，即 `heappush(heap,element)`，以及抽出最小元素 `heappop(heap)`。

```
def test_heapq():
    arr = [4, 3, 2, 5, 8, 9, 10, 1]
    import heapq
    heapq.heapify(arr)
    print(heapq.heappop(arr))
    heapq.heappush(arr, 13)
    while arr:
        print(heapq.heappop(arr), end=',')
```

## 优先级队列
优先级队列是一个抽象类型数据，能够添加元素，并取出键数字最小的那个元素。

在生成哈夫曼编码和在图中找到两个点的最短路径（Dijkstra 算法）时，利用优先级队列对一个数组进行排序（用堆排序算法），十分有用。

