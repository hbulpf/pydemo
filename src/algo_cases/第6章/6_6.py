from collections import deque
def gomaze(maze):
    length=len(maze)
    width=len(maze[0])
    visited=[[0 for _ in range(width)]for _ in range(length)]
    step=[[(-1,-1)for _ in range(width)]for _ in range(length)]
    direction=[[1,0],[-1,0],[0,-1],[0,1]]
    queue=deque([(0,0)])
    visited[0][0]=1
    result=[]
    while(queue):
        x,y=queue.popleft()
        if x==length-1 and y==width-1:
            break
        for d in direction:
            x1=x+d[0]
            y1=y+d[1]
            if  x1<0 or y1<0 or x1>=length or y1>=width or \
            visited[x1][y1]==1 or maze[x1][y1]==1:
                continue
            step[x1][y1]=(x,y)
            visited[x1][y1]=1
            queue.append((x1,y1))
    if step[length-1][width-1]==(-1,-1):
        return False
    re_x=length-1
    re_y=width-1
    result.append((length-1,width-1))
    while re_x and re_y:
        re_x,re_y=step[re_x][re_y]
        result.append((re_x,re_y))
    return result[::-1]
