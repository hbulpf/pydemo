class Solution(object):
    def func(self,num,max_num):
        if num<1 or max_num<1:
            return 0
        if num==1 or max_num==1:
            return 1
        if num<max_num:
            return self.func(num,num)
        if num==max_num:
            return 1+self.func(num,max_num-1)
        return self.func(num-max_num,max_num)+self.func(num,max_num-1)
