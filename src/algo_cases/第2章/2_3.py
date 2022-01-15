def Solution(nums):
#定义三个统计数量变量的初始值
    num0=num1=num2=0
    for num in nums:
    #统计0的数量
        if num==0: num0+=1
    #统计1的数量        
        if num==1:num1+=1    
    #统计2的数量       
        if num==2:num2+=1
    for i in range(num0):      
        nums[i]=0
    for i in range(num0,num0+num1):
        nums[i]=1 
    for i in range(num0+num1,len(nums)):
        nums[i]=2
    return nums
def Solution(nums):
    head=0#定义三个指针初始值
    current=0
    tail=len(nums)-1
    while current<=tail:#一趟三路快速排序
        if nums[current]<1:
            nums[current],nums[head]=nums[head],nums[current]
            head+=1
            current+=1  
        elif nums[current]>1:
            nums[current],nums[tail]=nums[tail],nums[current]
            tail-=1
        else:
            current+=1  
    return nums
