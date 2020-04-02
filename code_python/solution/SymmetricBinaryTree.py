# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        如果一个树的左子树与右子树镜像对称，那么这个树是对称的
        如果同时满足下面的条件，两个树互为镜像：
        它们的两个根结点具有相同的值。
        每个树的右子树都与另一个树的左子树镜像对称。
        """
        return self.isMirror(root,root)
    def isMirror(self,r1,r2):
        if r1== None and r2== None: return True
        elif r1 == None or r2 == None: return False
        return r1.val == r2.val and self.isMirror(r1.left,r2.right) and self.isMirror(r1.right,r2.left)
