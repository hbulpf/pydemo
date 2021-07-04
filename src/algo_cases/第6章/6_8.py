from collections import deque
def ShortestPath(link,N,K):
    graph=[[float('inf') for _ in range(N)]for _ in range(N)]
    for d in link:
        x=d[0]-1
        y=d[1]-1
        graph[x][y]=d[2]
    for i in range(N):
        graph[i][i]=0 
    K2other=[float('inf') for _ in range(N)]
    K2other[K-1]=0
    queue=deque([K-1])
    while queue:
        current=queue.popleft()
        for i in range(N):
            if K2other[current]+graph[current][i]<K2other[i]:
                K2other[i]=K2other[current]+graph[current][i]
                queue.append(i)
    if float('inf') in K2other:
        return -1
    return max(K2other) 
