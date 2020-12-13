package solution;

import common.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {

    /**
     * 和上题的区别在于这里root下一个循环要指向dummy.next，即下一层链表表头
     */
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0), cur = dummy;
            for (TreeLinkNode node = root; node != null; node = node.next) {
                if (node.left != null) {
                    cur.next = node.left;
                    cur = cur.next;
                }

                if (node.right != null) {
                    cur.next = node.right;
                    cur = cur.next;
                }
            }
            root = dummy.next;
        }
    }

    /** 递归，和上题相比改都不用改
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(0), cur = dummy;
        for (TreeLinkNode p = root; p != null; p = p.next) {
            if (p.left != null) {
                cur.next = p.left;
                cur = cur.next;
            }
            if (p.right != null) {
                cur.next = p.right;
                cur = cur.next;
            }
        }
        connect(dummy.next);
    }*/
}
