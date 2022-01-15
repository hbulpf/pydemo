def fourSum(self, array,sum_):
    array.sort()
    res=[]
    length=len(array)
    for i in range(length-3):#双层循环
        if i!=0 and array[i]==array[i-1]:
            continue
        for j in range(i+1,length-2):
            if j!=i+1 and array[j]==array[j-1]:continue
            l=j+1
            r=length-1
            while(l<r):
                s=array[i]+array[j]+array[l]+array[r]
                if(s==sum_ and [array[i],array[j],array[l],array[r]] not in res):
                    res.append([array[i],array[j],array[l],array[r]])
                    l+=1
                    r-=1
                    while(l<r and array[l]==array[l-1]):l+=1#元素去重
                    while(l<r and array[r]==array[r+1]):r-=1
                elif(s>sum_):
                    r-=1
                else:
                    l+=1
    return res
