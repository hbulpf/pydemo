# 贪婪算法

笼统来说， 这种算法在寻找解决方案的每个步骤中都选择了一个让局部结果最大化的参数。  

典例: 最小点积

![image-20211228110528852](pics/image-20211228110528852.png)

```
def min_scalar_prod(x, y):
    x = sorted(x)
    y = sorted(y)
    return sum(x[i] * y[-i - 1] for i in range(len(x)))
```

