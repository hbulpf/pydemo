class Solution:
    def func(self, nums, k):
        def reverse(nums,start,end):
            while start<end:
                tmp=nums[start]
                nums[start]=nums[end]
                nums[end]=tmp
                start+=1
                end-=1
        k%=len(nums)
        reverse(nums,0,len(nums)-1)
        reverse(nums,0,k-1)
        reverse(nums,k,len(nums)-1)
        return nums
