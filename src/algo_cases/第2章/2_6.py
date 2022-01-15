def largestNumber( nums):#函数名为largestNumber
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
def largestNumber( nums):#函数名为largestNumber
    from functools import cmp_to_key
    nums=sorted([str(i) for i in nums],key=cmp_to_key(lambda x,y:int(y+x)-int(x+y)))
    if int(''.join(nums))==0:
        return str(0)
    else:
        return ''.join(nums)
