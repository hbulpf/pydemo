#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
图的深度优先遍历
@Time : 2021/9/8 00:07
@Author: RunAtWorld
@File: dfs.py
"""


class DFS:
    @staticmethod
    def dfs_m(M):
        """
        对邻接矩阵进行深度优先遍历
        """
        visited = [0] * len(M)

        # 定义travel函数是为了遍历到孤立的点
        def dfs_travel(M, i):
            # 访问
            print(i,end="->")
            visited[i] = 1
            for j in range(len(M[i])):
                if M[i][j] and not visited[j]:
                    dfs_travel(M, j)

        for k in range(len(M)):
            if not visited[k]:
                dfs_travel(M, k)

    def bfs_adj(self, adj):
        """
        对邻接表进行深度优先遍历
        """
        visited = [0] * len(M)

        def dfs_travel(adj, i):
            # 访问
            print(i, )
            visited[i] = 1
            for j in range(len(adj[i])):
                if adj[i][j] and not visited[j]:
                    dfs_travel(adj, j)

        for k in range(len(adj)):
            if not visited[k]:
                dfs_travel(adj, k)


if __name__ == '__main__':
    M = [[0, 1, 1, 1], [1, 0, 1, 0], [1, 1, 0, 1], [1, 0, 1, 0]]
    DFS.dfs_m(M)
