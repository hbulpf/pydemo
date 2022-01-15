def bag(weight,value,max_weight):
    weight.insert(0,0)
    value.insert(0,0)
    thing_num=len(weight)
#建立一个thing_num*(max_weight+1)长度的二维列表
    dp=[]
    for i in range(thing_num):
        dp.append([0]*(max_weight+1))
    for i in range(1,thing_num):
        for j in range(1,max_weight+1):
            dp[i][j]=dp[i-1][j]
            if j>=weight[i]:
                dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
    return dp[thing_num-1][max_weight] 
