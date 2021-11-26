#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/9/6 23:17
@Author: RunAtWorld
@File: L111_MinimumDepthOfBinaryTree.py
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from tree_node import TreeNode


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left_depth = self.minDepth(root.left)
        right_depth = self.minDepth(root.right)
        return min(left_depth, right_depth) + 1 if left_depth and right_depth else left_depth + right_depth + 1
