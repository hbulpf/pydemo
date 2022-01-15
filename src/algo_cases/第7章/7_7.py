import sys
MAX=sys.maxsize
def mintree(graph,point):
    visited = [point[0]]
    length = [-1]
    n=len(point)
    for i in range(1,n):
        length.append(graph[0][i])
    sum = 0
    last=[point[0] for _ in range(n)]
    for _ in range(1,n):
        min=MAX
        minindex=0
        for j in range(1,n):
            if length[j]!=-1 and length[j]<min:
               min=length[j]
               minindex=j
        visited.append(minindex)
        sum += length[minindex]
        print(last[minindex], '--', point[minindex])
        length[minindex]=-1
        for j in range(1,n):
            if length[j]!=-1 and graph[minindex][j]<length[j]:
                length[j]=graph[minindex][j]
                last[j]=point[minindex]
    return sum
