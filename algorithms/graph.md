# 图

1. 图的存储
    1. 邻接矩阵，邻接表
    2. 邻接多重表，狮子链表
2. 图的遍历
    1. BFS
    2. DFS
3. 应用
    1. 最小生成树
        1. Prim算法
        2. Kruskal算法
    2. 最短路径
        1. Dijkstra算法
        2. Floy算法
    3. 拓扑排序 AOV网
    4. 关键路径 AOE网

## 图的遍历

### DFS

伪代码

```

DFS(u){             //访问顶点u
	vis[u] = true;   //设置u已被访问 
	for(从u出发能到达的所有顶点v){   //枚举从u出发可以到达的所有顶点v 
		if vis[v] == false           //如果v未被访问 
		DFS(v)            //递归访问v 
	}
} 

DFSTrave(G){       //遍历图 
	for(G的所有顶点){     //对G的所有顶点u 
		if vis[u] == false    //如果u未被访问 
		DFS(u)    //访问u所在的连通块 
	}
}
```

#### Python版本

```
'''
DFS是一直找邻，然后一直遍历下去，直到把所有的节点遍历完
用在解是否存在的问题中比较多吧
'''
# coding=utf-8
# 邻接矩阵M 递归实现DFS
def DFS(M, i, visited):
    j = 0
    visited[i] = 1
    print(i)   # 当然，你也可以干点别的...根据具体运用
    for i in range(len(M)):
        if M[i][j] and not visited[j]:
            DFS(M, j, visited)

def main(M):
    visited = [0]*len(M)
    for i in range(len(M)):
        DFS(M, i, visited)

M = [[0,1,1,1],[1,0,1,0],[1,1,0,1],[1,0,1,0]]
main(M)
```

#### C 版本

邻接矩阵版

```

const int MAXV = 1000;     //最大顶点数 
const int INF = 100000000;  //设INF为一个很大的数 
int n,G[MAXV][MAXV];       //n为顶点数 
bool vis[MAXV] = {false};

void DFS(int u,int depth){    //u为当前访问的顶点标号，depth为深度 
	vis[u] = true;
	//如果需要对u进行一些操作，可以在这里进行 
	//下面对所有从u出发能到达的分支顶点进行枚举 
	for(int v = 0;v <n;v++){    //对每个顶点v 
		if(vis[v] == false && G[u][v] != INF){     //如果v未被访问，且u可达到v 
			DFS(v,depth+1);    //访问v，深度+1（depth这里有什么用？） 
		}
	}
}

void DFSTrave(){   //遍历图G 
	for(int u = 0;u <n;u++){   //对每个顶点u 
		if(vis[u] == false){   //如果u未被访问 
			DFS(u,1);         //访问u和u所在的连通块，1表示初始为第一层 
		}
	}
}
```

邻接表版

```

const int MAXV = 1000;     //最大顶点数 
const int INF = 100000000;  //设INF为一个很大的数 

vector<int> Adj[MAXV];
int n;
bool vis[MAXV] = {false};

void DFS(int u,int depth){
	vis[u] = true;
	//如果需要对u进行一些操作，可以在此处进行
	for(int i = 0;i <Adj[u].size();i++){
		int v = Adj[u][i];
		if(vis[v] == false){
			DFS(v,depth+1);
		}
	} 
}

void DFSTrave(){
	for(int u = 0;u <n;u++){
		if(vis[u] == false){
			DFS(u,1);
		}
	}
}
```

### BFS

#### Python版本

```
# BFS主要是用来寻找最短路径
# 从某一点出发，加入队列，然后当这个点出队列，则马上把它的所有邻点加入队列，
# 重复的做这个过程，直到所有点遍历完
# 在此过程中可以有一些终止条件，可用来寻找最短距离/我们想要的目的。

def BFS(M):   # M邻接矩阵
    visited = [0]*len(M)
    queue = []
    for i in range(len(M)):
        if not visited[i]:
            visited[i] = 1
            queue.append(i)
            print(i)
        while queue:
            cur = queue.pop(0)
            for j in range(len(M)):
                if M[i][j] and not visited[j]:
                    print j    # 根据实际问题，这个可以做别的处理
                    queue.append(j)  # 把和节点i有关系的邻都依次的加入队列
                    visited[j] = 1   # 且做visited标记

M = [[0,1,1,1],[1,0,1,0],[1,1,0,1],[1,0,1,0]] 
BFS(M)
```



## 参考

1. [详解两种算法：深度优先遍历（DFS）和广度优先遍历（BFS）](https://developer.51cto.com/art/202004/614590.htm)
2. [图的两种遍历方式：DFS、BFS](https://zhuanlan.zhihu.com/p/76596674)
3. [图的DFS（邻接矩阵版、邻接表版）](https://blog.csdn.net/weixin_42377217/article/details/104182467)