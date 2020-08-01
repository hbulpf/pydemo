package solution;

import common.ListNode;

/**
 * Created by dingjiekrbo on 2016/11/17.
 * https://leetcode.com/articles/intersection-two-linked-lists/
 */

public class IntersectionOfTwoLinkedLists {

    // 耗时2ms
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        for (ListNode p = headA; p != null; p = p.next, lenA++);
        for (ListNode p = headB; p != null; p = p.next, lenB++);
        ListNode p = lenA > lenB ? headA : headB;
        ListNode q = lenA > lenB ? headB : headA;
        for (int i = 0; i < Math.abs(lenA - lenB); i++, p = p.next);
        for ( ; p != null && q != null; p = p.next, q = q.next) {
            if (p == q) {
                return p;
            }
        }
        return null;
    }
}
