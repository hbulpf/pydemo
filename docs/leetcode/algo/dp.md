# 动态规划

典例: 计算斐波那契数列第 n 个数


## 力扣题目

leetcode [70.爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

列出状态转移方程，发现
```
f(1) = 1
f(2) = 2
f(3) = f(2)+f(1)
...
f(n) = f(n-1)+f(n-2)
```
发现其和斐波那契数列是同一个问题。