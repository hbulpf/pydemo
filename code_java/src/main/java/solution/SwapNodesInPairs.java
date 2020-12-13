package solution;

import common.enties.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);

        ListNode node = head, tail = dummy;

        for ( ; node != null && node.next != null; ) {
            ListNode next = node.next;
            node.next = tail.next;
            tail.next = node;

            ListNode nnext = next.next;
            next.next = node;
            tail.next = next;
            tail = node;

            node = nnext;
        }

        tail.next = node;

        return dummy.next;
    }
}
