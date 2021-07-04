def symmetric(root):
    if not root: return True
    queue=[]
    queue.append(root.left)
    queue.append(root.right)
    while(queue):
        root1=queue.pop()
        root2=queue.pop()
        if not root1 and not root2:
            continue
        if not root1 or not root2:
            return False
        if root1.val!=root2.val:
            return False
        if root1.left or root2.left or root1.right or root2.right:
            queue.append(root1.left)
            queue.append(root2.right)
            queue.append(root1.right)
            queue.append(root2.left)
    return True


def symmetric(root):
    if root:
        return dfs(root.left,root.right)
    return True
def dfs(root1,root2):
    if not root1 and not root2:
        return True
    if not root1 or not root2:
        return False
    return root1.val==root2.val and dfs(root1.left,root2.right) and dfs(root1.right,root2.left)
