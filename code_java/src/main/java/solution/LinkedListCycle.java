package solution;

import common.enties.ListNode;

public class LinkedListCycle {

    // 注意判空
    public boolean hasCycle(ListNode head) {
        for (ListNode fast = head, slow = head; fast != null && fast.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
