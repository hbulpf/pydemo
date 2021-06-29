import os

key=input('请输入您想要查询的关键字\n')

for path,dir,file in os.walk('.'):
    k=False
    for name in file:
        if key in name:
            print(path,'==>',name)
            k=True
    if k==True:
        print('-'*50)

