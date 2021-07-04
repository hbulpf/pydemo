import sys
def dijkstra(graph,point,start):
    length=graph[start]
    use=[0 for _ in range(len(graph))]
    use[start]=1
    front=[point[start] for _ in range(len(graph))]
    for i in range(len(graph)):
        minid=0
        min_=sys.maxsize
        for j in range(len(length)):
            if not use[j] and length[j]<min_:
                min_=length[j]
                minid=j
        use[minid]=1
        for k in range(len(graph)):
            if not use[k] and min_+graph[minid][k]<length[k]:
                length[k]=min_+graph[minid][k]
                front[k]=point[minid]    
    return length,front
