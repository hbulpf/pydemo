class Solution:
    def findmedian(self, array1, array2):
        len1=len(array1)
        len2=len(array2)
        if len1>len2:
            return self.findmedian(array2,array1)
        if len1<=2:
            if len2>4:
                p1=math.ceil(len2/2)-2
                array2=array2[p1:-p1]
            nums=array1+array2
            nums.sort()
            return self.getmediannum(nums)
        p2=math.ceil(len1/2)-1
        if self.getmediannum(array1)<self.getmediannum(array2):
            return self.findmedian(array1[p2:],array2[:-p2])
        else:
            return self.findmedian(array1[:-p2],array2[p2:])  
#定义一个取数组中位数的函数       
    def getmediannum(self,nums):
        return (nums[len(nums)//2]+nums[(len(nums)-1)//2])/2
