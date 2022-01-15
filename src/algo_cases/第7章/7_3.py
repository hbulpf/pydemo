def largestNumber(nums):
    nums=[str(i) for i in nums]
    for i in range(len(nums)-1):
        for j in range(i+1,len(nums)):
            if int(nums[i]+nums[j])<int(nums[j]+nums[i]):
                temp=nums[i]
                nums[i]=nums[j]
                nums[j]=temp
    if int(''.join(nums))==0:
        return str(0)
    else:
        return ''.join(nums)


from functools import cmp_to_key 
def largestNumber(nums):
    nums=[str(i) for i in nums]
    nums.sort(key=cmp_to_key(lambda x,y:int(y+x)-int(x+y)))
    if int(''.join(nums))==0:
        return '0'
    else: 
        return ''.join(nums)
