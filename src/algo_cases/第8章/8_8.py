class Solution(object):
    def main(self, root):   #主函数main
        self.max_length=0 #全局变量，用于保存当前最长同值路径
        self.A(root)
        return self.max_length
    def A(self,root):    #被调函数，也是递归函数
        if not root: 
            return 0
        left=self.A(root.left)
        right=self.A(root.right)
        if root.left and root.left.val==root.val:
            left+=1
        else:
            left=0
        if root.right and root.right.val==root.val:
            right+=1
        else:
            right=0
        self.max_length=max(self.max_length,left+right)
        return max(left,right) #返回给上层的是左右子路径最长同值路径
