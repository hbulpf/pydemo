package solution;

/**
 * 这题可以用segment tree或binary index tree(bit)，两者时间复杂度都是lgn，不过segment tree因为用到树，
 * 而bit用的是数组，所以bit更省空间。
 *
 * 关于BIT，可以参考http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * 关于Segment Tree，可以参考 https://discuss.leetcode.com/topic/29918/17-ms-java-solution-with-segment-tree
 *
 * https://leetcode.com/articles/range-sum-query-mutable/
 */
public class NumArrayII {

    private int[] bit;

    private int[] nums;

    public NumArrayII(int[] nums) {
        this.nums = nums;

        bit = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    private void init(int i, int val) {
        i++;
        while (i < bit.length) {
            bit[i] += val;
            i += i & (-i);
        }
    }

    private int getSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    /**
    private solution.SegmentTreeNode mRoot;

    public solution.NumArrayII(int[] nums) {
        mRoot = buildTree(nums, 0, nums.length - 1);
    }

    private solution.SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        solution.SegmentTreeNode root = new solution.SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        }
        int mid = start + ((end - start) >>> 1);
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int i, int val) {
        update(mRoot, i, val);
    }

    private void update(solution.SegmentTreeNode root, int i, int val) {
        int start = root.start, end = root.end;

        if (start == end) {
            root.sum = val;
            return;
        }
        int mid = start + ((end - start) >>> 1);
        if (i <= mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(mRoot, i, j);
    }

    public int sumRange(solution.SegmentTreeNode root, int i, int j) {
        int start = root.start, end = root.end;

        if (start == i && end == j) {
            return root.sum;
        }

        int mid = start + ((end - start) >>> 1);

        if (j <= mid) {
            return sumRange(root.left, i, j);
        } else if (i > mid) {
            return sumRange(root.right, i, j);
        } else {
            return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
        }
    }*/
}

// Your solution.NumArray object will be instantiated and called as such:
// solution.NumArray numArray = new solution.NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
