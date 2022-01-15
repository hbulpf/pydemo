def isPalindrome(self, head):
    if head==None or head.next==None:return True
    fast=slow=head
    while fast.next!=None and fast.next.next!=None:
        slow=slow.next
        fast=fast.next.next
    def reverselink(self,head):
        current=None
        pre=None
        while(head!=None):
            current=head.next
            head.next=pre
            pre=head
            head=current
        return pre
    start=reverselink(slow.next)
    while(start!=None):
        if(head.val!=start.val):
            return False
        head=head.next
        start=start.next
    return True
