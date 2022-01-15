def maxDepth(root):
    if root:
        return 0
    else:
        return max(maxDepth(root.left),maxDepth(root.right))+1


def minDepth(root):
    if not root:
        return 0
    if not root.left:
        return self.minDepth(root.right)+1
    elif not root.right:
        return self.minDepth(root.left)+1
    else:
        return min(minDepth(root.left),minDepth(root.right))+1
