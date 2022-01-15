def moveZeroes(self, array):
    lastnotzero=0#可确定的最后一个非零元素指针的下一位
    for current in range(len(array)):
        if(array[current]!=0):
            array[lastnotzero]=array[current]
        if lastnotzero!=current:
            array[current]=0
        lastnotzero+=1
    return array
