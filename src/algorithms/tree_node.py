#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/12/27 23:49
@Author: RunAtWorld
@File: tree_node.py
@Project: PyCharm
"""


class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        return str(self.val)


def bfs_tree_with_queue(root: TreeNode):
    """
    bfs 使用队列遍历树
    """
    if not root:
        return
    queue = [root]

    while queue:
        n = queue.pop(0)
        print(n.val, end=',')
        if n.left:
            queue.append(n.left)
        if n.right:
            queue.append(n.right)


def bfs_recursive(root: TreeNode):
    """
    bfs 递归遍历树
    bfs递归形式，是利用dfs的递归形式，在递归过程中记录每个node的level，然后将属于一个level的node放入同一list
    """
    res = []

    def travel(root: TreeNode, level, res_list):
        if not root:
            return
        if level >= len(res_list):
            sub_list = [root]
            res_list.append(sub_list)
        else:
            res_list[level].append(root)
        travel(root.left, level + 1, res_list)
        travel(root.right, level + 1, res_list)

    travel(root, 0, res)
    for arr in res:
        for j in arr:
            print(j, end=',')


def dfs_tree_with_stack(root: TreeNode):
    """
    dfs 使用堆遍历树
    """
    if not root:
        return
    stack = [root]

    while stack:
        node = stack.pop()
        print(node.val, end=',')
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)


def dfs_recursive(root: TreeNode):
    """
    dfs 递归遍历树
    """
    if not root:
        return
    print(root.val, end=',')
    if root.left:
        dfs_recursive(root.left)
    if root.right:
        dfs_recursive(root.right)


def draw_tree(root: TreeNode):
    if not root:
        return


if __name__ == '__main__':
    n9 = TreeNode(9)
    n8 = TreeNode(8)
    n7 = TreeNode(7)
    n6 = TreeNode(6)
    n5 = TreeNode(5, right=n9)
    n4 = TreeNode(4, left=n8)
    n3 = TreeNode(3, n6, n7)
    n2 = TreeNode(2, n4, n5)
    n1 = TreeNode(1, n2, n3)
    print("bfs:")
    bfs_tree_with_queue(n1)
    print("\nbfs_recursive:")
    bfs_recursive(n1)
    print("\ndfs:")
    dfs_tree_with_stack(n1)
    print("\ndfs_recursive:")
    dfs_recursive(n1)
"""
bfs:
1,2,3,4,5,6,7,8,9,
bfs_recursive:
1,2,3,4,5,6,7,8,9,
dfs:
1,2,4,8,5,9,3,6,7,
dfs_recursive:
1,2,4,8,5,9,3,6,7,
"""