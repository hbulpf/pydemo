package solution;

import common.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfBinaryTree {

    /**
     * leetcode测试用例中p和q一定是在树中的
     * 奇怪的是如果判断用root.val == p.val这种就不能AC，必须用root == p
     * 确实，树中可能会存在值重复的节点
     */
    // 耗时11ms
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null) {
            return right != null ? root : left;
        } else {
            return right;
        }
    }

    /**
     * 这是迭代写法，另外考虑了p或者q不在树中的情况
     * 用一个map保存每个node的前驱节点，当p和q同时找到了则回溯他们的前驱节点查看是否重合。
     * 如果树遍历完了还没有同时找到p和q则返回null
     */
    /**
     * 耗时29ms
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            if (parents.containsKey(p) && parents.containsKey(q)) {
                break;
            }

            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                parents.put(node.left, node);
            }

            if (node.right != null) {
                queue.add(node.right);
                parents.put(node.right, node);
            }
        }

        if (!parents.containsKey(p) || !parents.containsKey(q)) {
            return null;
        }

        Set<TreeNode> set = new HashSet<TreeNode>();
        for (TreeNode node = p; node != null; node = parents.get(node)) {
            set.add(node);
        }

        for (TreeNode node = q; node != null; node = parents.get(node)) {
            if (set.contains(node)) {
                return node;
            }
        }

        return null;
    }
}
