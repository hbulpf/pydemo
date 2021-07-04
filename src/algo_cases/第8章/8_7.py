class Solution:   
    def findNode(self, root, Left, Right):
        def dfs(root):
            if root:
                if root.val<Left:
                    dfs(root.right)
                elif root.val>Right:
                    dfs(root.left)
                else:
                    self.num+=root.val
                    dfs(root.right)
                    dfs(root.left)
        self.num=0
        dfs(root)
        return self.num
