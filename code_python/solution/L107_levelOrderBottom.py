# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        queue = []
        if root is None:
            return result
        else:
            queue.append(root)
        while queue != []:
            result.insert(0,[])
            length = len(queue)
            for i in range(length):
                temp = queue.pop(0)
                result[0].append(temp.val)
                if temp.left:
                    queue.append(temp.left)
                if temp.right:
                    queue.append(temp.right)
        return result
