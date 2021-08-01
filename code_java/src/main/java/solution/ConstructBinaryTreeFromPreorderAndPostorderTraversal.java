package solution;

import common.enties.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /**
     * 这里先记录一下post每个数对应的索引，免得每次去找
     * 不过找找也没关系，因为每个元素不会重复找
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode helper(int[] pre, int prestart, int preend, int[] post, int poststart, int postend, HashMap<Integer, Integer> map) {
        if (prestart > preend || poststart > postend) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prestart]);
        if (prestart + 1 <= preend) {
            int len = map.get(pre[prestart + 1]) - poststart + 1;
            root.left = helper(pre, prestart + 1, prestart + len, post, poststart, poststart + len - 1, map);
            root.right = helper(pre, prestart + len + 1, preend, post, poststart + len, postend - 1, map);
        }
        return root;
    }
}
