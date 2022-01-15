from collections import deque
def square(n):
    selected=[i**2 for i in range(1,int(n**0.5)+1)]
    visited = set()
    queue=deque([(0,0)])
    while(queue):
        current,height=queue.popleft()
        for i in selected:
            sum_= current+i
            if sum_==n:
                return height+1
            if sum_<n and sum_ not in visited:
                visited.add(sum_)
                queue.append((sum_,height+1))


def square(n):
    dp=[i for i in range(n+1)]
    for i in range(4,n+1):
        for j in range(int(n**0.5),0,-1):
            if i>=j**2:
                dp[i]=min(dp[i],dp[i-j*j]+1)
    return dp[n]
