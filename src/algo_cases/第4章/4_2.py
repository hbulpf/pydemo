def threeSum(self, array):
    array.sort()
    length=len(array)
    res=[]
    for i in range(length):#三层循环
        for j in range (i+1,length):
            for k in range(j+1,length):
                if array[i]+array[k]+array[j]==0 and not [array[i],array[j],array[k]] in res:
                    res.append([array[i],array[j],array[k]])
    return res


def threeSum(self, array):
    array.sort()
    res= []
    for k in range(len(array) - 2):
        if array[k] > 0: break
        if k > 0 and array[k] == array[k - 1]: continue 
        l, r= k + 1, len(array) - 1
        while l < r:
            s = array[k] + array[l] + array[r]
            if s < 0:
                l += 1
                while l < r and array[l] == array[l - 1]: l += 1#进行元素去重
            elif s > 0:
                r -= 1
                while l < r and array[r] == array[r + 1]: r -= 1
            else:
                res.append([array[k], array[l], array[r]])
                l += 1
                r -= 1
                while l < r and array[l] == array[l - 1]: l += 1
                while l < r and array[r] == array[r + 1]: r -= 1
    return res
