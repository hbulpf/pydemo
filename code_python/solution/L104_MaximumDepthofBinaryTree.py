#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/9/6 23:11
@Author: RunAtWorld
@File: L104_MaximumDepthofBinaryTree.py.py
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from tree_node import TreeNode


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left_depth = self.maxDepth(root.left)
        right_depth = self.maxDepth(root.right)
        return max(left_depth, right_depth) + 1
