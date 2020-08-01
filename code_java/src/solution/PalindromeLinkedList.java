package solution;

import common.ListNode;

public class PalindromeLinkedList {

    // 耗时2ms
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow);
        /**
         * 注意退出条件是p1 != slow
         */
        for (ListNode p1 = head, p2 = fast; p1 != slow; p1 = p1.next, p2 = p2.next) {
            if (p1.val != p2.val) {
                return false;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (node != null) {
            ListNode next = node.next;
            node.next = cur.next;
            cur.next = node;
            node = next;
        }
        return dummy.next;
    }
}
