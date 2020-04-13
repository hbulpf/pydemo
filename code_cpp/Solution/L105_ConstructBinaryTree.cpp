/**
 * 题目：105.从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 
 * 题解：
 * 前序遍历中第一个节点是根节点，在中序遍历中找到根节点的位置，
 * 其左边是左子树，右边是右子树，确定了左右子树包含的节点数后，
 * 继续访问前序遍历的下一个节点，递归处理左右子树即可
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return buildTreeCore(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
    }

    TreeNode* buildTreeCore(vector<int>& preorder,int preStart,int preEnd, vector<int>& inorder,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return nullptr;
        TreeNode* n = new TreeNode(preorder[preStart]);
        
        if(preStart == preEnd && inStart == inEnd && preorder[preStart] == inorder[inStart])
            return n;

        int rootIndex = inStart;
        while(rootIndex <= inEnd && inorder[rootIndex] != preorder[preStart])
            rootIndex++;
        
        int leftLen = rootIndex - inStart;
        int leftPreorderEnd = preStart + leftLen;
        if(leftLen > 0)
            n->left = buildTreeCore(preorder,preStart+1,leftPreorderEnd,inorder,inStart,rootIndex-1);
        int rightLen = inEnd - rootIndex;
        if(rightLen > 0)
            n->right = buildTreeCore(preorder,leftPreorderEnd+1,preEnd,inorder,rootIndex+1,inEnd);
        return n;
    }
};