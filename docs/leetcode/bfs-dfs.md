# bfs和dfs

树节点的定义
```python
class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
```


## DFS

深度优先遍历: 从图中一个未访问的顶点 V 开始，沿着一条路一直走到底，然后从这条路尽头的节点回退到上一个节点，再从另一条路开始走到底...，不断递归重复此过程，直到所有的顶点都遍历完成，它的特点是不撞南墙不回头，先走完一条路，再换一条路继续走。

### 递归实现

```python
def dfs_recursive(root: TreeNode):
    """
    dfs 递归遍历树
    """
    if not root:
        return
    print(root.val, end=',')
    if root.left:
        dfs_recursive(root.left)
    if root.right:
        dfs_recursive(root.right)
```

### 非递归实现

DFS非递归实现要用到栈

遍历树
```python
def dfs_tree_with_stack(root: TreeNode):
    """
    使用栈实现dfs
    """
    if not root:
        return
    stack = [root]
    while stack:
        node = stack.pop()
        print(node.val, end=',')
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
```

遍历图
```python
def dfs_graph_with_stack(graph,s):
    """
    dfs遍历图, s指的是开始结点
    """
    stack=[]
    stack.append(s)
    #是否访问过
    seen=set()
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

bfs递归形式，是利用dfs的递归形式，在递归过程中记录每个node的level，然后将属于一个level的node放入同一list

```python
def bfs_recursive(root: TreeNode):
    """
    bfs 递归遍历树
    bfs递归形式，是利用dfs的递归形式，在递归过程中记录每个node的level，然后将属于一个level的node放入同一list
    """
    res = []

    def travel(root: TreeNode, level, res_list):
        if not root:
            return
        if level >= len(res_list):
            sub_list = [root]
            res_list.append(sub_list)
        else:
            res_list[level].append(root)
        travel(root.left, level + 1, res_list)
        travel(root.right, level + 1, res_list)

    travel(root, 0, res)
    for arr in res:
        for j in arr:
            print(j, end=',')
```


### 非递归实现

BFS非递归实现要用到队列


遍历树
```python
def bfs_tree_with_queue(root: TreeNode):
    """
    bfs 使用队列遍历树
    """
    if not root:
        return
    queue = [root]
    while queue:
        node = queue.pop(0)
        print(node.val, end=',')
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
```

遍历图
```python
def bfs_graph_with_queue(graph,s):
    """
    bfs 使用队列遍历图, s指的是开始结点
    """
    queue=[]
    queue.append(s)
    #看是否访问过该结点
    seen=set()
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

## 力扣题目

1. leetcode [104](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)，[111](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/): 给定一个二叉树，找出其最大/最小深度。 

   例如：给定二叉树 [3,9,20,null,null,15,7],

   ```
      3 
     / \ 
    9  20 
      /  \ 
     15   7 
   ```

   则它的最小深度 2，最大深度 3。

   思路: 使用深度遍历的思想，递归遍历左右子树的最大/最小深度.但在得到最小深度时，注意树某个子节点为空的情况。

   ```java
   
   ```
   
2. leetcode 102: 给你一个二叉树，请你返回其按层序遍历得到的节点值。(即逐层地，从左到右访问所有节点)。示例，给定二叉树：[3,9,20,null,null,15,7]。

   ```
      3 
     / \ 
    9  20 
      /  \ 
     15   7 
   ```

   返回其层次遍历结果：

   ```
   [ 
     [3], 
     [9,20], 
     [15,7] 
   ] 
   ```
   
   思路: 这道题是广度优先遍历的变种，只需要在广度优先遍历的过程中，把每一层的节点都添加到同一个数组中即可，问题的关键在于遍历同一层节点前，必须事先算出同一层的节点个数有多少(即队列已有元素个数)。
   
   使用bfs思路的代码
   
   ```python
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        from collections import deque
        q = deque([root])
        res = []
        while q:
            level_len = len(q)
            level = []
            while level_len > 0:
                node = q.popleft()
                level.append(node.val)
                level_len -= 1
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(level)
        return res
   ```
   
   使用dfs思路的代码: 这题用 BFS 是显而易见的，但其实也可以用 DFS. 
   
   DFS 可以用递归来实现，其实只要在递归函数上加上一个「层」的变量即可，只要节点属于这一层，则把这个节点放入相当层的数组里
   
   ```python
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        travel_list = []
   
        def dfs(root: TreeNode, level: int):
            if not root:
             return
            if len(travel_list) < level + 1:
                travel_list.append([])
            travel_list[level].append(root.val)
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
   
        dfs(root, 0)
        return travel_list
    ```


## 参考

1. [python实现图的DFS和BFS](https://blog.csdn.net/weizhifei1234/article/details/88787352)
2. [二叉树DFS和BFS 递归/非递归](https://blog.csdn.net/l947069962/article/details/84786140)
3. [掌握树的四种遍历方式，以及BFS, DFS](https://cloud.tencent.com/developer/column/85153)
