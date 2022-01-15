class solution():
    def func(self,input_str,replace):
        replace_len=len(replace)
        count=0
        for i in input_str:
            if i==' ':
                count+=1
        new_len=len(input_str)+(replace_len-1)*count
        new_string=[None for i in range(new_len)]
        point_new=new_len-1
        point_origin=len(input_str)-1
        while point_origin>=0 and point_origin<=point_new:
            if input_str[point_origin]==' ':
                new_string[point_new-replace_len+1:point_new+1]=replace
                point_new-=replace_len
            else:
                new_string[point_new]=input_str[point_origin]
                point_new-=1
            point_origin-=1
        return ''.join(new_string)
