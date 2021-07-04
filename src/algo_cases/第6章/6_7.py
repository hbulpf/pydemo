from collections import deque
def land(matrix):
    length=len(matrix)
    width=len(matrix[0])
    re=[[0 for _ in range(width)]for _ in range(length)]
    direction=[[1,0],[-1,0],[0,1],[0,-1]]
    queue=deque([])
    for i in range(length):
        for j in range(width):
            if matrix[i][j]==1:
                re[i][j]=0
                queue.append((i,j))
            else:
                re[i][j]=-1
    while queue:
        x,y=queue.popleft()
        for d in direction:
            x1=x+d[0]
            y1=y+d[1]
            if x1>=0 and y1>=0 and x1<length and y1<width and re[x1][y1]==-1:
                re[x1][y1]=re[x][y]+1
                queue.append((x1,y1))
    return re
