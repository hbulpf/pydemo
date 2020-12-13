package solution;

import common.ListNode;

public class InsertionSortList {

    /**
     * 其实很简单，就是从head中每次取一个节点，插到dummy中适当的位置
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        for (ListNode next; head != null; head = next) {
            next = head.next;
            for (ListNode cur = dummy; cur != null; cur = cur.next) {
                if (cur.next != null && head.val > cur.next.val) {
                    continue;
                }
                head.next = cur.next;
                cur.next = head;
                break;
            }
        }
        return dummy.next;
    }
}
