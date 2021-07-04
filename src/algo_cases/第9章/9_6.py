class Solution(object):
    def mergenlinks(self, links):
        length=len(links)
        iterval=1
        while length>iterval:
            for i in range(0,length-iterval,iterval*2):
                links[i]=self.merge2links(links[i],links[i+iterval])
            iterval*=2
        return links[0] if length>0 else None
    def merge2links(self, head1, head2):
        point=mergedhead=ListNode(None)
        while head1 and head2:
            if head1.val <= head2.val:
                point.next = head1
                head1 = head1.next
            else:
                point.next = head2
                head2 = head2.next
            point = point.next
        if not head1:
            point.next=head2
        else:
            point.next=head1
        return mergedhead.next
