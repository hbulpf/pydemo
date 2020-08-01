package solution;

import common.RandomListNode;

/**
 * 易错的地方在于random要判空
 */
public class CopyListWithRandomPointer {


    public RandomListNode copyRandomList(RandomListNode head) {
        for (RandomListNode p = head; p != null; ) {
            RandomListNode next = p.next;
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = next;
        }
        for (RandomListNode p = head; p != null; ) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        RandomListNode dummy = new RandomListNode(0), cur = dummy;
        for (RandomListNode p = head; p != null; ) {
            cur.next = p.next;
            cur = cur.next;
            p.next = p.next.next;
            p = p.next;
        }
        return dummy.next;
    }
}


