class ListNode(object):#链表中节点类
    def __init__(self, x):
        self.val = x
        self.next = None
#判断是否有环函数Cycle
def Cycle(self, head):
    if head==None:return False
    fast=head
    slow=head
    while(fast):
        if fast.next==None:
            return False
        fast=fast.next.next
        slow=slow.next
        if fast==slow:
            return True
    return False
