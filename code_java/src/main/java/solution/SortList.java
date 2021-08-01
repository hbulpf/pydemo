package solution;

import common.enties.ListNode;

/**
 * 这题采用merge sort，可自顶向下或自底向上
 * 区别是自顶向下是递归的，需要额外的空间
 * 而自底向上不用
 * 时间复杂度都是O(nlgn)
 */
public class SortList {

    /**
     * 自顶向下
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for ( ; l1 != null && l2 != null; ) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }  else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    /**
     * 自底向上
     */
    public ListNode sortList2(ListNode head) {
        int size = 0;
        for (ListNode node = head; node != null; node = node.next, size++);
        ListNode dummy = new ListNode(0);
        ListNode left, right, cur, tail;
        for (int step = 1; step <= size; step *= 2) {
            for (cur = head, tail = dummy; cur != null; ) {
                left = cur;
                right = split(left, step);
                cur = split(right, step);
                tail = merge(left, right, tail);
            }
            head = dummy.next;
        }
        return dummy.next;
    }

    /**
     * 将l1和l2合并后挂在tail下，返回新的tail
     */
    ListNode merge(ListNode l1, ListNode l2, ListNode tail) {
        for ( ; l1 != null && l2 != null; ) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }  else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        for ( ; tail.next != null; tail = tail.next);
        return tail;
    }

    /**
     * 从start开始取step个节点，返回下一个节点
     */
    private ListNode split(ListNode start, int step) {
        for (step--; start != null && step > 0; step--, start = start.next);
        if (start != null && start.next != null) {
            ListNode next = start.next;
            start.next = null;
            return next;
        }
        return null;
    }
}
