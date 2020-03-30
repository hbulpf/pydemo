import java.util.Arrays;
import java.util.List;

/**
 * 这题理解了好久才搞明白
 * 建立一棵二叉树，从数组末尾开始遍历，这里每个树的节点要记录sum和dup
 * dup表示到当前为止，该节点重复的次数
 * sum表示该节点左子树中的节点总数，注意如果有的节点有重复也要算上。
 * 现在假如遍历到了数组中的第i个数，则其右边的所有数都已经生成了节点插到树中，
 * 此时我们只要统计从树的root开始，遍历到num[i]对应的树节点为止，所有路径上小于num[i]的节点的sum和dup之和即可，
 * 注意也要算上num[i]节点本身的sum
 */
public class CountOfSmallerNumbersAfterSelf {

    class Node {
        Node left, right;
        int val, sum, dup = 1;

        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    /**
     * preSum表示遍历到num的当前index为止，并且遍历到了node，所有遍历过的数中小于node值的数的个数
     */
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            // 如果相等，
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (num < node.val) {
            // 如果是递减，则不算入preSum
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            // 如果是递增，则要累积node的dup和sum
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}
