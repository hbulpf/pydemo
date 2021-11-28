# 力扣初级算法


## 数组

### 旋转图像

### 将图像顺时针旋转 90 度

给定一个 *n* × *n* 的二维矩阵 `matrix` 表示一个图像。请你将图像顺时针旋转 90 度。

![image-20211128215334154](questions/image-20211128215334154.png)

这个题目的关键是: 旋转操作常用方法是 找到一行中为一组的点，逐层变换位置，找到四个对应的点，确认变换规律。规律为:

```
matrix[i][j] = matrix[len-j-1][i];
matrix[len-j-1][len-i-1] = matrix[len-i-1][len-j-1];
matrix[n][len-j-1] = matrix[j][len-i-1];
matrix[j][len-i-1] = matrix[i][j];
```

找到这样的规律后，再做就不难。

![image-20211128215742339](questions/image-20211128215742339.png)

```python
def rotate(self, matrix: List[List[int]]) -> None:
    width = len(matrix)
    k = width // 2
    for i in range(k):
        for j in range(i, width - i -1):
            m = width - i - 1
            n = width - j - 1
            tmp = matrix[i][j]
            matrix[i][j] = matrix[n][i]
            matrix[n][i] = matrix[m][n]
            matrix[m][n] = matrix[j][m]
            matrix[j][m] = tmp
```

如果需要做顺时针旋转 180度、270度，方法也是类似。
