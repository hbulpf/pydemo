public class RemoveDuplicateList {

    /**
     * 一个链表，删除相邻且重复的
     * 如 1, 3, 3, 3, 1, 2, 4, 4，只保留1, 1, 2
     */
    public ListNode removeDup(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;

        ListNode last = null;
        int count = 0;

        for (ListNode p = head; p != null; p = p.next) {
            if (last == null || last.val == p.val) {
                last = p;
                count++;
            } else {
                if (count == 1) {
                    cur.next = last;
                    cur = cur.next;
                }
                last = p;
                count = 1;
            }
        }

        if (last != null && count == 1) {
            cur.next = last;
            cur = cur.next;
        }

        cur.next = null;
        return dummy.next;
    }

    // 可在上面的基础上精简
    // count是可以去掉的
    public ListNode removeDup2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0), cur = dummy;
        ListNode last = head;

        for (ListNode p = head.next; p != null; p = p.next) {
            if (last.val != p.val) {
                if (last.next == p) {
                    cur.next = last;
                    cur = cur.next;
                }
                last = p;
            }
        }
        cur.next = (last.next == null ? last : null);
        return dummy.next;
    }
}
