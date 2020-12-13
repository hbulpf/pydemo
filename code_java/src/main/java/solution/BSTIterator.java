package solution;

import common.TreeNode;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> mStack;
    private TreeNode mCurNode;

    public BSTIterator(TreeNode root) {
        mStack = new Stack<>();
        mCurNode = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !mStack.isEmpty() || mCurNode != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int result = -1;

        while (hasNext()) {
            if (mCurNode != null) {
                mStack.push(mCurNode);
                mCurNode = mCurNode.left;
            } else {
                mCurNode = mStack.pop();
                result = mCurNode.val;
                mCurNode = mCurNode.right;
                break;
            }
        }

        return result;
    }
}
