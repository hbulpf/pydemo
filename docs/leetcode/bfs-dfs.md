# bfs和dfs

## DFS

深度优先遍历: 从图中一个未访问的顶点 V 开始，沿着一条路一直走到底，然后从这条路尽头的节点回退到上一个节点，再从另一条路开始走到底...，不断递归重复此过程，直到所有的顶点都遍历完成，它的特点是不撞南墙不回头，先走完一条路，再换一条路继续走。

### 递归实现

### 非递归实现

DFS非递归实现要用到栈

遍历树
```python
def dfs_tree_with_stack(self, root: TreeNode):
    """
    使用栈实现dfs
    """
    if not root:
        return
    stack = [root]
    while stack:
        node = stack.pop()
        self.process(node)
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
```

遍历图
```python
def dfs(graph,s):
    #图  s指的是开始结点
    #需要一个栈
    stack=[]
    stack.append(s)
    seen=set()#看是否访问过
    seen.add(s)
    while (len(stack)>0):
        #拿出邻接点
        vertex=stack.pop()#这里pop参数没有0了，最后一个元素
        nodes=graph[vertex]
        for w in nodes:
            if w not in seen:#如何判断是否访问过，使用一个数组
                stack.append(w)
                seen.add(w)
        print(vertex)
```

## BFS

### 递归实现


### 非递归实现

BFS非递归实现要用到队列


遍历树
```python
def bfs_tree(self, root: TreeNode):
    if not root:
        return
    queue = [root]
    while queue:
        node = queue.pop(0)
        self.process(node)
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
```

遍历图
```python
def bfs(graph,s):
    #graph图  s指的是开始结点
    queue=[]
    queue.append(s)
    seen=set()#看是否访问过该结点
    seen.add(s)
    while (len(queue)>0):
        vertex=queue.pop(0)#保存第一结点，并弹出，方便把他下面的子节点接入
        nodes=graph[vertex]#子节点的数组
        for w in nodes:
            if w not in seen:#判断是否访问过，使用一个数组
                queue.append(w)
                seen.add(w)
        print(vertex)       
```

## 参考

1. [python实现图的DFS和BFS](https://blog.csdn.net/weizhifei1234/article/details/88787352)
