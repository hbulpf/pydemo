class Solution:
    def Treeprint(self, root):
        result=[]
        treenode_list=[]
        if not root:
            return result
        treenode_list.append(root)
        while treenode_list:
            current_result=[]
            nextnode_list=[]
             for node in treenode_list:
                current_result.append(node.val)
                if node.left:
                    nextnode_list.append(node.left)
                if node.right:
                    nextnode_list.append(node.right)
            result.append(current_result)
            treenode_list=nextnode_list
        return result
