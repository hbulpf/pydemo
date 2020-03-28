/**
 * https://leetcode.com/articles/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    // 耗时0ms
    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(0);

        for (ListNode p = head; p != null; ) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }

        return dummy.next;
    }
}
