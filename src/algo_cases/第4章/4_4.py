def maxArea(self, height):
    res=0
    left=0
    right=len(height)-1
    while(left<right):
        res=max(res,min(height[left],height[right])*(right-left))
        if(height[left]<height[right]):
            left+=1
        else:
            right-=1
    return res
