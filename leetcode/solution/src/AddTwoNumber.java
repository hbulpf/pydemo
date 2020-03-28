public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;

        for (int carry = 0; l1 != null || l2 != null || carry > 0; ) {
            int n1 = l1 != null ? l1.val : 0;
            l1 = l1 != null ? l1.next : null;
            int n2 = l2 != null ? l2.val : 0;
            l2 = l2 != null ? l2.next : null;

            int sum = n1 + n2 + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = node;
            cur = node;
        }

        return dummy.next;
    }
}
