package solution;

import common.enties.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 这题是要找BST中出现次数最多的节点集合，这里允许有重复节点
 * 思路很简单，中序遍历，会按升序排列，再统计重复的值
 * 但是这样会消耗额外空间，对于类似于1，2，3，4...n-1, n-1，这种，所有的元素都只出现1次，
 * 唯独n-1出现了两次，这样mList中要保存整棵树的元素，所以空间是O(n），而返回值事实上只有一个
 * 这是分配在堆上的而非栈上，不能忽略。
 *
 * 如果额外空间要求为O(l)，则分开两次扫描，第一次扫描最大次数，不记录最大次数的元素集合
 * 第二次根据最大次数来收集元素
 */
public class FindModeInBinarySearchTree {

    /**
     * 这题类似于在一个有序的序列中查找频率最高的元素集合
     */

    private List<Integer> mList;

    private int mCurCount;

    private int mMaxCount;

    private Integer mCurValue;

    public int[] findMode(TreeNode root) {
        mList = new LinkedList<>();

        inorderTraverse(root);

        int[] res = new int[mList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mList.get(i);
        }
        return res;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);


        if (mCurValue != null && root.val != mCurValue) {
            mCurCount = 1;
        } else {
            mCurCount++;
        }

        mCurValue = root.val;

        if (mCurCount > mMaxCount) {
            mList.clear();
            mList.add(mCurValue);
            mMaxCount = mCurCount;
        } else if (mCurCount == mMaxCount) {
            mList.add(mCurValue);
        }

        inorderTraverse(root.right);
    }
}
