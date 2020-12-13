package solution;

import common.enties.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 这题算法比较直观
 */
public class MostFrequentSubtreeSum {

    /**
     * key为sum，value为出现的次数
     */
    private HashMap<Integer, Integer> mCounts;

    /**
     * key为次数，value为出现该次数的所有sum
     */
    private HashMap<Integer, List<Integer>> mMap;

    private int mMaxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        mCounts = new HashMap<>();
        mMap = new HashMap<>();

        helper(root);

        List<Integer> list = mMap.get(mMaxCount);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        Integer sum = left + right + root.val;


        int count = mCounts.getOrDefault(sum, 0);
        mCounts.put(sum, count + 1);

        mMaxCount = Math.max(mMaxCount, count + 1);

        if (mMap.containsKey(count)) {
            mMap.get(count).remove(sum);
        }

        List<Integer> list = mMap.get(count + 1);
        if (list == null) {
            list = new LinkedList<>();
            mMap.put(count + 1, list);
        }
        list.add(sum);

        return sum;
    }
}
