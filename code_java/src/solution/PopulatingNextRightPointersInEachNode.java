package solution;

public class PopulatingNextRightPointersInEachNode {

    /** 递归法，巧妙地运用dummy使代码很简洁
     *  假定当前root所在层已连好，要连下一层
     */
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
    }

    /**
     * 将递归转成非递归很简单，就加一层循环，且结尾处加root = dummy.next即可
     * @param root
     */
    public void connect2(TreeLinkNode root) {
        while (root != null) {
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

            root = dummy.next;
        }
    }
}
