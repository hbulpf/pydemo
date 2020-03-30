/**
 * 将数组切成m段，求所有段中最大值的最小值
 * 我们倒过来思考，假设这个值为k，则意味着所有段的和都不会超过k，如果我们能确保这种情况下数组能被切成m段，则表明k是候选的值。那怎样确保k是最小值呢？
 * 简单的办法是让k从最小开始，依次递增，k最小是多少呢，如果不考虑具体的m，显然是数组中的最大值，而k的最大值是整个数组的和。现在我们考虑m，如果k设置的太小，
 * 则为了保证所有段的和都小于k，势必段要缩短长度以降低sum，而这样的话可能段的个数会超过m。如果k设置的太大，则势必段的长度要增加，而这样的话可能段的个数会达不到m，
 * 所以k和m是线性关系，为了找到最小的那个k，我们可以用二分查找法。
 */
public class SplitArrayLargestSum {

    /**
     * 这里二分查找时关键要注意的是只剩两个数时的情况，即r-l=1时，
     * 假设最终结果是l，则mid为l，isTargetBig返回true，所以返回l
     * 如果最终结果是r，则mid为l，isTargetBig返回false，所以l=mid+1=r，返回r
     */
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int l = max, r = sum;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (isTargetBig(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     *  如果target小了则返回false，正常或者大了则返回true
     */
    private boolean isTargetBig(int target, int[] nums, int m) {
        int sum = 0, count = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                sum = nums[i];
                if (++count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    /** 这种写法好理解一些，注意count==m时，也要缩小右边界，因为我们要找到尽可能小的值，假如mid恰好就是最小的值，之后left会加回来的
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        int left = max, right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = getCount(nums, mid);
            if (count > m) {
                left = mid + 1;
            } else if (count <= m) {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getCount(int[] nums, int k) {
        int sum = 0, count = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > k) {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }*/

}
