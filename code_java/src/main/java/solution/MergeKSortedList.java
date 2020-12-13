package solution;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/articles/merge-k-sorted-list/
 */

public class MergeKSortedList {

    // 耗时19ms
    // 时间复杂度为O(knlgn)，空间复杂度O(k)
    /**
     * 这里要注意lists中可能有node为null
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), cur = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }

    /**
     * 第二种方法
     * 时间复杂度O(Nlgk)，空间O(l)
     * 耗时10ms
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = helper(lists, start, mid);
        ListNode l2 = helper(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummy;
        for ( ; p != null && q != null; ) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        cur.next = p != null ? p : q;
        return dummy.next;
    }
}
