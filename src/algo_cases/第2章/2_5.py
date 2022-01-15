def pancakeSort(nums: List[int]) -> List[int]:
    res=[]
    for i in range(len(nums)-1,-1,-1):
        index=nums.index(max(nums[:i+1]))
        nums[:index+1]=nums[:index+1][::-1]
        res.append(index+1)
        nums[:i+1]=nums[:i+1][::-1]
        res.append(i+1)
    return res
