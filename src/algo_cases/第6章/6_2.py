from collections import deque
def maxDepth( root):
    if not root:
        return 0
    ans=0
    queue=deque([root])
    while queue:
        tmp=[]
        while queue:
            node=queue.popleft()
            if node.left:
                tmp.append(node.left)
            if node.right:
                tmp.append(node.right)
        queue.extend(tmp)
        ans+=1
    return ans



from collections import deque
def minDepth(root):
    if not root:return 0
    queue=deque([(1,root)])
    while(queue):
        depth,node=queue.popleft()
        if node and not node.left and  not node.right:
            return depth
        if node:
            queue.append((depth+1,node.left))
            queue.append((depth+1,node.right))
