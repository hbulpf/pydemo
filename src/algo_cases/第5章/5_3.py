def balance(root):
    if not root:
        return True
    return balance(root.left) and balance(root.right) and abs(maxDepth(root.left)-maxDepth(root.right))<=1
def maxDepth(root):
    if root:
        return 0
    else:
        return max(maxDepth(root.left),maxDepth(root.right))+1

def balance(root):
    if dfs(root)==-1:
        return False
    return True
def dfs(root):
    if not root:
        return 0
    left=dfs(root.left)
    if left==-1:
        return -1
    right=dfs(root.right)
    if right==-1:
        return -1
    return max(left,right)+1 if abs(left - right) < 2 else -1
