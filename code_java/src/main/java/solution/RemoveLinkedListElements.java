package solution;

import common.enties.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0), node = dummy;
        for ( ; head != null; head = head.next) {
            if (head.val != val) {
                node.next = head;
                node = node.next;
            }
        }
        node.next = null;
        return dummy.next;
    }
}
