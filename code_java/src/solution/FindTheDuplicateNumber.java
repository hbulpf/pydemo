package solution;

/**
 * 题目的意思是有n+1个数，这些数的范围限定在[1,n]，其中只有一个重复数，重复的次数不限
 */
public class FindTheDuplicateNumber {

    /**
     * 这道题涉及木桶原理，如果元素个数比桶多，说明有些桶里装了多个元素。
     * 一共迭代lgn次，每次O(n)，因此时间复杂度O(nlgn)，空间O(l)
     */
    public int findDuplicate(int[] nums) {
        int min = 1, max = nums.length - 1;

        while (min < max) {
            int mid = (min + max) / 2;

            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            /**
             * 如果count>mid，说明元素个数count比桶数mid还大，则可以肯定重复的数在[1,mid]中
             * 但是count<=mid就能确定重复的数肯定不在[1,mid]中么？不一定吧，接下来推理一下：
             * 我们看右边的一半，[mid+1,n]区间的数有n+1-count个，可见元素有n+1-count个，桶有n-mid个，而count<=mid等价于count-1<mid，
             * 因此元素个数大于桶数，右区间一定有重复的数，由于题目已经限定只有一个重复数，因此只能在右区间
             */
            if (count > mid) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
