def sortList(head):
    if head is None or head.next is None:return head
    mid=getmid(head)
    l=head
    r=mid.next
    mid.next=None#将左右两个部分断开
    return merge(sortList(l),sortList(r))
def getmid(head):
    slow=fast=head
    if head is None :return slow
    while fast.next and fast.next.next:
        slow=slow.next
        fast=fast.next.next
    return slow
def merge(l,r):
    a=ListNode(0)
    q=a
    while l and r:
        if l.val>r.val:
            q.next=r
            r=r.next
        else:
            q.next=l
            l=l.next
        q=q.next
    if l:
        q.next=l
    if r:
        q.next=r
    return a.next
