class solution():
    def func(self,n):
        re=[2]
        i=3
        for i in range(3,n):
            j=2
            for j in range(2,i):
                if i%j==0:
                    break
                if i%j!=0:
                    re.append(i)
        return re
