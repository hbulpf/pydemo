#!/usr/bin/env python
# -*- coding: utf-8 -*-
from queue import Queue

from tree_node import TreeNode


class BFS():
    def process(self, node: TreeNode):
        print(node.val, end=',')

    def bfs_tree(self, root: TreeNode):
        if not root:
            return
        queue = [root]
        while queue:
            node = queue.pop(0)
            self.process(node)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)


if __name__ == '__main__':
    sample = BFS()
    n4 = TreeNode(4, None, None)
    n5 = TreeNode(5, None, None)
    n6 = TreeNode(10, None, None)
    n7 = TreeNode(7, None, None)
    n2 = TreeNode(2, n4, n5)
    n3 = TreeNode(3, n6, n7)
    n0 = TreeNode(1, n2, n3)
    sample.bfs_tree(n0)
