# 深度优先遍历和广度优先遍历

## 树

树是图的一种特例(连通无环的图就是树)

![](./pics/q_tree.png)

### DFS

深度优先遍历: 从图中一个未访问的顶点 V 开始，沿着一条路一直走到底，然后从这条路尽头的节点回退到上一个节点，再从另一条路开始走到底...，不断递归重复此过程，直到所有的顶点都遍历完成，它的特点是不撞南墙不回头，先走完一条路，再换一条路继续走。

#### 递归实现

递归实现比较简单，由于是前序遍历，所以我们依次遍历当前节点，左节点，右节点即可，对于左右节点来说，依次遍历它们的左右节点即可，依此不断递归下去，直到叶节点(递归终止条件)。

```java
public class Solution { 
    private static class Node { 
        public int value; 
        public Node left; 
        public Node right; 
 
        public Node(int value, Node left, Node right) { 
            this.value = value; 
            this.left = left; 
            this.right = right; 
        } 
    } 
 
    public static void dfs(Node treeNode) { 
        if (treeNode == null) { 
            return; 
        } 
        // 遍历节点 
        process(treeNode) 
        // 遍历左节点 
        dfs(treeNode.left); 
        // 遍历右节点 
        dfs(treeNode.right); 
    } 
} 
```

递归的表达性很好，也很容易理解，不过如果层级过深，很容易导致栈溢出。

#### 非递归实现

仔细观察深度优先遍历的特点，对二叉树来说，由于是先序遍历(先遍历当前节点，再遍历左节点，再遍历右节点)，所以我们有如下思路：

对于每个节点来说，先遍历当前节点，然后把右节点压栈，再压左节点(这样弹栈的时候会先拿到左节点遍历，符合深度优先遍历要求)。

弹栈，拿到栈顶的节点，如果节点不为空，重复步骤 1， 如果为空，结束遍历。

整体思路还是比较清晰的，使用栈来将要遍历的节点压栈，然后出栈后检查此节点是否还有未遍历的节点，有的话压栈，没有的话不断回溯(出栈)。

```java
public static void dfsWithStack(Node root) { 
    if (root == null) { 
        return; 
    } 
    Stack<Node> stack = new Stack<>(); 
    // 先把根节点压栈 
    stack.push(root); 
    while (!stack.isEmpty()) { 
        Node treeNode = stack.pop(); 
        // 遍历节点 
        process(treeNode) 
 
        // 先压右节点 
        if (treeNode.right != null) { 
            stack.push(treeNode.right); 
        } 
 
        // 再压左节点 
        if (treeNode.left != null) { 
            stack.push(treeNode.left); 
        } 
    } 
} 
```

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

### BFS

广度优先遍历树
```java
private static void bfs(Node root) { 
    if (root == null) { 
        return; 
    } 
    Queue<Node> stack = new LinkedList<>(); 
    stack.add(root); 
 
    while (!stack.isEmpty()) { 
        Node node = stack.poll(); 
        System.out.println("value = " + node.value); 
        Node left = node.left; 
        if (left != null) { 
            stack.add(left); 
        } 
        Node right = node.right; 
        if (right != null) { 
            stack.add(right); 
        } 
    } 
} 
```

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


## 参考

1. [图文详解两种算法：深度优先遍历（DFS）和广度优先遍历（BFS）](https://developer.51cto.com/art/202004/614590.htm)