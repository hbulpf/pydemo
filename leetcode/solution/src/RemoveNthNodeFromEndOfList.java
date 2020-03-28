/**
 * https://leetcode.com/articles/remove-nth-node-end-list/
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        for (int i = 1; i < n; i++) {
            p = p.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;

        for ( ; p.next != null; p = p.next) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummy.next;
    }
}
