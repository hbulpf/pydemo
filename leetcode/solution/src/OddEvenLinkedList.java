public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0), pOdd = odd;
        ListNode even = new ListNode(0), pEven = even;

        int index = 1;
        for (ListNode p = head; p != null; p = p.next) {
            if ((index++ & 1) > 0) {
                pOdd.next = p;
                pOdd = pOdd.next;
            } else {
                pEven.next = p;
                pEven = pEven.next;
            }
        }

        pOdd.next = null;
        pEven.next = null;

        pOdd.next = even.next;
        return odd.next;
    }
}
