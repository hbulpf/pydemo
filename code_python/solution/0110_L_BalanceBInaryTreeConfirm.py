# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        对二叉树做深度优先遍历DFS，递归过程中：
        终止条件：当DFS越过叶子节点时，返回高度0；
        返回值：
        从底至顶，返回以每个节点root为根节点的子树最大高度(左右子树中最大的高度值加1max(left,right) + 1)；
        当我们发现有一例 左/右子树高度差 ＞ 1 的情况时，代表此树不是平衡树，返回-1；
        当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
        最差情况是对树做一遍完整DFS，时间复杂度为 O(N)。
        """
        return self.dfs(root) != -1
    def dfs(self,root):
        if not root: return 0
        left = self.dfs(root.left)
        if left == -1: return -1
        right = self.dfs(root.right)
        if right == -1: return -1
        return max(left,right)+1 if abs(left-right)<2 else -1