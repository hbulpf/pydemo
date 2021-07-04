inputarray=[1,2,3]
def allsort():
    temp = []
    dfs(0,temp)
def dfs(position,temp):
    if position == len(inputarray):
        print(temp)
    for i in inputarray:
        if i not in temp :
            temp.append(i)
            dfs(position + 1,temp)
            temp.pop()           
allsort()
