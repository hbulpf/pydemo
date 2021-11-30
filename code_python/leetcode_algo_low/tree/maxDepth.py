#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/11/30 0:02
@Author: RunAtWorld
@File: maxDepth.py
@Project: PyCharm
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        return 0