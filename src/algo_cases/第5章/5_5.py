class Max: 
    def MaxPath(self, root):
        self.res= float('-inf')
        self.dfs(root)
        return self.res
    def dfs(self, root):
        if not root:
            return 0
        left = max(0, self.dfs(root.left))
        right = max(0, self.dfs(root.right))
        self.res = max(self.res, left + root.val + right)
        return root.val + max(left, right)
