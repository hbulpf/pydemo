def change(value,count,money):
    re=0
    for i in range(len(value)-1,-1,-1):
        num=min(int(money/value[i]),count[i])
        money=money-num*value[i]
        re+=num
    if money>0:
        return -1
    return re
