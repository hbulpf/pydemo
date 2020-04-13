/**
 * 题目：98.验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *   2
 *  / \
 * 1   3
 * 输出: true
 * 
 * 示例 2:
 * 输入:
 *   5
 *  / \
 * 1   4
 *    / \
 *   3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 
 * 题解：
 * 边界递归：每次递归记录最大和最小的节点值，判断当前节点值是否符合BST的规定
 * 中序遍历：中序遍历访问二叉树，判断序列是否符合升序
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
    bool isValidBST(TreeNode* root) {
        return isValidBSTHelper(root,LLONG_MIN,LLONG_MAX);
    }

    bool isValidBSTHelper(TreeNode* root, long lower,long upper){
        if(!root)
            return true;
        long long curVal = root->val;
        if(root->val <= lower || root->val >= upper)
            return false;
        return isValidBSTHelper(root->left,lower,curVal) && isValidBSTHelper(root->right,curVal,upper);
    }


    // 中序遍历、递归
    bool isValidBST(TreeNode* root,TreeNode** pre) {
        if(!root)
            return true;
        if(!isValidBST(root->left,pre))
            return false;
        if(*pre && (*pre)->val >= root->val)
            return false;
        *pre = root;
        if(!isValidBST(root->right,pre))
            return false;
        return true;

    }

    //中序遍历迭代
    bool isValidBST_1(TreeNode* root) {
        TreeNode* pre = nullptr;
        stack<TreeNode*> s;
        TreeNode* cur = root;
        while(!s.empty()|| cur){
            if(cur){
                s.push(cur);
                cur = cur->left;
            }else{
                cur = s.top();
                s.pop();
                if(pre && pre->val >= cur->val)
                    return false;
                pre = cur;
                cur = cur->right;
            }
        }
        return true;
    }
};