/**
 * https://leetcode.com/articles/binary-tree-longest-consecutive-sequence/
 */
public class BinaryTreeLongestConsecutiveSequence {

    private int longest;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestConsecutive(root, 0, root.val);
        return longest;
    }

    public void longestConsecutive(TreeNode root, int length, int target) {
        if (root == null) {
            return;
        } else if (root.val == target) {
            length++;
        } else {
            length = 1;
        }
        longest = Math.max(longest, length);
        longestConsecutive(root.left, length, root.val + 1);
        longestConsecutive(root.right, length, root.val + 1);
    }


}
