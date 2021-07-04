class solution():
    def func(self,num,n):
        str_list=[]
       dic={0:'0',1:'1',2:'2',3:'3',4:'4',5:'5',6:'6',7:'7',8:'8',9:'9',10:'A',
           11:'B',12:'C',13:'D',14:'E',15:'F'}
        while True:
            if num==0:
                break
            next_num=num//n
            add_num=num%n
            str_list.insert(0,str(dic[add_num]))    
            num=next_num
        return ''.join(str_list)  
