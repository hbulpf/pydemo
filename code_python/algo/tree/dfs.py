#!/usr/bin/env python
# -*- coding: utf-8 -*- 

from algo.tree.tree_node import TreeNode


class DFS:
    def process(self, node: TreeNode):
        print(node.value, end=',')

    def dfs_recursively(self, root: TreeNode):
        """
        递归实现 dfs
        """
        if not root:
            return
        self.process(root)
        self.dfs_recursively(root.left)
        self.dfs_recursively(root.right)

    def dfs_with_stack(self, root: TreeNode):
        """
        使用栈实现dfs
        """
        if not root:
            return
        stack = [root]
        while stack:
            node = stack.pop()
            self.process(node)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)


if __name__ == '__main__':
    sample = DFS()
    n4 = TreeNode(4, None, None)
    n5 = TreeNode(5, None, None)
    n6 = TreeNode(10, None, None)
    n7 = TreeNode(7, None, None)
    n2 = TreeNode(2, n4, n5)
    n3 = TreeNode(3, n6, n7)
    n0 = TreeNode(1, n2, n3)
    sample.dfs_recursively(n0)
    print()
    sample.dfs_with_stack(n0)
