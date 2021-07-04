def bag(matrix,max):
    re = 0
    re_list=[0 for _ in range(len(matrix))]
    matrix.sort(key=lambda x: x[1]/float(x[0]),reverse=True)
    for i in range(len(matrix)):
        if matrix[i][0]<max:
            re+=matrix[i][1]
            max-=matrix[i][0]
            re_list[i] = 1
        else:
            re += max * matrix[i][1]/float(matrix[i][0])
            re_list[i] = max/float(matrix[i][0])
            break
    return matrix,re_list,re
