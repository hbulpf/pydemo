package solution;

import common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Dp的解法可以参考https://discuss.leetcode.com/topic/2940/java-solution-with-dp
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return Collections.EMPTY_LIST;
        }
        return generateTrees(1, n);
    }

    // 从start到end之间取一个数作为root，左边构成left，右边构成right
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }

            }
        }
        return list;
    }

    /**
     * 这里面明显有重复计算的部分，可缓存[1,n]的结果加速，时间降到2ms
     */
    /*
    public List<TreeNode> generateTrees(int start, int end, List<TreeNode>[] map) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == 1 && map[end] != null) {
            return map[end];
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1, map);
            List<TreeNode> rights = generateTrees(i + 1, end, map);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        if (start == 1) {
            map[end] = result;
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return Collections.EMPTY_LIST;
        }
        List<TreeNode>[] map = new LinkedList[n + 1];
        return generateTrees(1, n, map);
    }*/

    /**
     * 可考虑迭代的DP写法
     */
    /*
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.EMPTY_LIST;
        }

        List<TreeNode>[] map = new LinkedList[n + 1];
        map[0] = new LinkedList<>();
        map[0].add(null);

        for (int i = 1; i <= n; i++) {
            map[i] = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : map[j - 1]) {
                    for (TreeNode right : map[i - j]) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = clone(right, j);
                        map[i].add(root);
                    }
                }
            }
        }

        return map[n];
    }

    public TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode root = new TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }
    */
}
