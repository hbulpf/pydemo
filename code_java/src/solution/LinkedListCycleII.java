package solution;

public class LinkedListCycleII {
    /**
     * 这里有个问题，如果链表是a,b，然后又回到a
     * 则slow和fast必须都从head起步才行
     * 如果slow从head起步，fast从head.next起步，则这里会死循环
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        for (; fast != null && fast.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        for (ListNode node = head; node != slow; node = node.next, slow = slow.next);
        return slow;
    }
}
