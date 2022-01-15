
def insertionSortList(head: ListNode) -> ListNode:
    if head is None or head.next is None: return head
    p=head.next
    head.next=None
    while(p is not None):
    	p_head=p.next
        current=head
        if(p.val<=head.val):
            p.next=head
            head=p
        else:
            while(current.next and current and current.next.val<=p.val):
                current=current.next
                p.next=current.next
                current.next=p
        p=p_head
    return head
