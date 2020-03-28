import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 本题要注意的一个是溢出，一个是查重
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i + 3 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j + 2 < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long newTarget = target - nums[i] - nums[j];
                for (int k = j + 1, m = nums.length - 1; k < m; ) {
                    long sum = nums[k] + nums[m];
                    if (sum > newTarget) {
                        m--;
                    } else if (sum < newTarget) {
                        k++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));

                        for (k++, m--; k < m && nums[k] == nums[k - 1] && nums[m] == nums[m + 1]; k++, m--);
                    }
                }
            }
        }

        return result;
    }
}
