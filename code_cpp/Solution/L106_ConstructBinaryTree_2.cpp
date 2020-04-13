/**
 * 题目：从中序与后序遍历遍历序列构建二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 
 * 题解：
 * 后序遍历序列的最后一个元素是二叉树的根节点，找到这个节点在中序遍历中的位置，其左边的子序列为左子树，
 * 右边的序列为右子树，确定了其左右子树的节点数后，可以向前访问后序遍历，递归的构建根节点的左右子树
 * 
 **/ 

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return buildTreeCore(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1);
    }

    TreeNode* buildTreeCore(vector<int>& inorder,int inStart,int inEnd,vector<int>& postorder,int postStart,int postEnd){
        if(inStart > inEnd || postStart > postEnd)
            return nullptr;
        TreeNode* root = new TreeNode(postorder[postEnd]);
        if(postStart == postEnd && inStart == inEnd && postorder[postEnd] == inorder[inStart])
            return root;
        
        int rootIndex = inStart;
        while(rootIndex <= inEnd && inorder[rootIndex] != postorder[postEnd])
            rootIndex++;
        
        int leftLen = rootIndex - inStart;
        if(leftLen > 0)
            root->left = buildTreeCore(inorder,inStart,rootIndex-1,postorder,postStart,postStart+leftLen-1);
        int rightLen = inEnd - rootIndex;
        if(rightLen > 0)
            root->right = buildTreeCore(inorder,rootIndex+1,inEnd,postorder,postStart+leftLen,postEnd-1);

        return root;
    }
};