import numpy


class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        m : 列数
        n : 行数
        """
        n = len(obstacleGrid)
        m = len(obstacleGrid[0])
        map_array = numpy.zeros((n, m), dtype=int)
        for i in range(m):
            if obstacleGrid[0][i] == 0:
                map_array[0][i] = 1
            else:
                break
        for i in range(n):
            if obstacleGrid[i][0] == 0:
                map_array[i][0] = 1
            else:
                break
        for i in range(1, n):
            for j in range(1, m):
                if obstacleGrid[i][j] == 0:
                    map_array[i][j] = map_array[i][j - 1] + map_array[i - 1][j]
        return map_array[-1][-1]




