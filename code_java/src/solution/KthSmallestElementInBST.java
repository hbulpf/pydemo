package solution;

import java.util.Stack;

/**
 * 这题关键是follow up
 * 如果更新频繁，则通常的做法每次都是O(n)，更优的做法是O(lgn)
 * 即给node中记录左子树的节点个数，这样在找kth smallest时流程如下：
 * 假设root的左子树节点有N个，则
 * 1， 当K=N+1时，kth就是root
 * 2,  当K<N+1时，kth就到左子树中找
 * 3， 当K>N+1时，就到右子树中找第K-N-1个
 * 所以当给定一棵树时，我们要先重建一下这棵树，统计一下各节点的左子树节点数，虽然首次是O(n）
 * 但是之后就是O(h)了。
 */
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (--k == 0) {
                    return root.val;
                }

                root = root.right;
            }
        }
        throw new IllegalStateException();
    }

    public int kthSmallest2(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
    }

    public int kthSmallest(TreeNodeWithCount root, int k) {
        if (root == null) {
            return -1;
        }

        if (root.left != null) {
            if (k <= root.left.count) {
                return kthSmallest(root.left, k);
            } else if (k == root.left.count + 1) {
                return root.val;
            } else {
                return kthSmallest(root.right, k - root.left.count - 1);
            }
        }

        if (k == 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k - 1);
        }
    }

    private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNodeWithCount nroot = new TreeNodeWithCount(root.val);
        nroot.left = buildTreeWithCount(root.left);
        nroot.right = buildTreeWithCount(root.right);

        if (nroot.left != null) {
            nroot.count += nroot.left.count;
        }

        if (nroot.right != null) {
            nroot.count += nroot.right.count;
        }
        return nroot;
    }

    class TreeNodeWithCount {
        TreeNodeWithCount left, right;
        int count, val;

        TreeNodeWithCount(int val) {
            this.val = val;
            this.count = 1;
        }
    }
}
