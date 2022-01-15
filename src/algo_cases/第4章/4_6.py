def water(self, height):
    left=0
    right=len(height)-1
    leftmax=rightmax=0
    res=0
    while(left<right):
        if(height[left]<height[right]):
            if(height[left]>=leftmax):
                leftmax=height[left]
            else:
                res+=leftmax-height[left]
            left+=1
        else:
            if(height[right]>=rightmax):
                rightmax=height[right]
            else:
                res+=rightmax-height[right]
            right-=1
    return res
