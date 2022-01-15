def climbStairs(n):
    count = [0,1,2]
    for i in range(3,n+1):#填充一维数组过程
        count.append(count[i-1]+count[i-2])
    return count[n]
