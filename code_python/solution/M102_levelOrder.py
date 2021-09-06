# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import List

from tree_node import TreeNode


class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        levels = []
        if not root:
            return levels

        def helper(node, level):
            # start the current level
            if len(levels) == level:
                levels.append([])

            # append the current node value
            levels[level].append(node.val)

            # process child nodes for the next level
            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)

        helper(root, 0)
        return levels

    def levelOrder1(self, root: TreeNode) -> List[List[int]]:
        """
        使用BFS的方法
        """
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

    def levelOrder2(self, root: TreeNode) -> List[List[int]]:
        """
        使用DFS的方法
        """
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
