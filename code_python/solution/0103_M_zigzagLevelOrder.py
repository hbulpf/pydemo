# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        results = []
        def dfs(root,level,flag):
            """
            flag: True--顺序;False--逆序
            """
            if not root:return
            if level == len(results):
                results.append([])
            if flag:
                results[level].append(root.val)
            else:
                results[level].insert(0,root.val)
            if root.left:
                dfs(root.left,level+1,not flag)
            if root.right:
                dfs(root.right,level+1,not flag)
        dfs(root,0,True)
        return results
