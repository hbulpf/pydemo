#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
图的广度优先遍历
@Time : 2021/9/8 00:07
@Author: RunAtWorld
@File: bfs.py
"""


class BFS:
    @staticmethod
    def bfs_m(M):
        """
        对邻接表进行广度优先遍历
        """
        visited = [0] * len(M)
        que = []
        for i in range(len(M)):
            if not visited[i]:
                print(i, end='->')
                visited[i] = 1
                que.append(i)
            while que:
                # 访问
                v = que.pop(0)
                for j in range(len(M[v])):
                    if M[v][j] and not visited[j]:
                        #这里有可能会重复添加，因此将添加时作为访问时机，这和树的bfs不太一样。
                        print(j, end='->')
                        visited[j] = 1
                        que.append(j)


if __name__ == '__main__':
    M = [[0, 1, 1, 1], [1, 0, 1, 0], [1, 1, 0, 1], [1, 0, 1, 0]]
    BFS.bfs_m(M)
