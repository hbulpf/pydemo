class Solution:
    def findnum(self, nums):
        def func(low,high):
            if low==high:
                return nums[low]
            mid=low+(high-low)//2
            head=func(low,mid)
            tail=func(mid+1,high)
            if head==tail:
                return tail
            head_count=sum(1 for i in range(low,high+1) if nums[i]==head)
            tail_count=sum(1 for i in range(low,high+1) if nums[i]==tail)
            return head if head_count>tail_count else tail
        return func(0,len(nums)-1)


class Solution:
    def findnum(self, nums):
        dic={}
        for i in nums:
            dic[i]=dic.get(i,0)+1
        return max(dic.keys(),key=dic.get)

class Solution:
    def findnum(self, nums):
        times=1
        re=nums[0]
        for i in range(1,len(nums)):
            if times==0:
                re=nums[i]
                times+=1
            elif nums[i]==re:
                times+=1
            else:
                times-=1
        return re
