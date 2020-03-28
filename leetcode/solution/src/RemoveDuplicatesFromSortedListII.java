public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0), tail = dummy;
        ListNode prev = head, cur = head.next;

        for ( ; cur != null; cur = cur.next) {
            if (prev.val != cur.val) {
                if (prev.next == cur) {
                    tail.next = prev;
                    tail = tail.next;
                }
                prev = cur;
            }
        }

        tail.next = prev.next == null ? prev : null;
        return dummy.next;
    }
}
