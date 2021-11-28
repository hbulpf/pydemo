# 常见题目汇总

## Google
 - [Remove consecutive node from single list](code_java/src/solution/RemoveDuplicateList.java)
 - [Reverse pairs](code_java/src/solution/CountReversePairs.java)


## 常见笔试题
1. 打印素数
2. 给定入栈顺序，给出一组出栈顺序，判断是否满足条件。如入栈 ：12345 出栈：21453]
1. 寻找和为定值的任意多个数
    ```
    问题描述：
    给定n个不同的正整数，整数k（k < = n）以及一个目标数字。在这n个数里面找出K个数，
    使得这K个数的和等于目标数字，求问有多少种方案？
    给出[1,2,3,4]，k=2， target=5，[1,4] and [2,3]是2个符合要求的方案
    ```
4. 给定一个二维数组，求其中连续子数组和的最大值。
    ```
    问题描述：给定一个二维数组，求其中连续子数组和的最大值。
    样例输入： 
    1  5  -3  6  -7
    3  5  -9  -4  6
    -8  4  0  12 -3
    3  -1  5  -5  8
    样例输出：20  
    4  0 12 -3
    -1 5 -5  8
    ```
5. [原地删除排序数组中的重复项](https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/)
   ```python
   def removeDuplicates(self, nums: List[int]) -> int:
    """
    使用逆序删除，巧妙避开删除元素时引起数组长度变化的影响
    """
    if not nums:
        return len(nums)
    for i in range(len(nums)-1,0,-1):
        if nums[i] == nums[i-1]:
            nums.pop(i)
    return len(nums)
   ```
   
   ```python
   def removeDuplicates(self, nums: List[int]) -> int:
    """
    这里用到了List的 count函数，统计某个元素的个数。但注意次方法建立了切片，不再是原地
    """
    if not nums:
        return len(nums)
        for i in nums[:]:
        if nums.count(i) != 1:
            nums.pop(nums.index(i))
    return len(nums)
   ```

## 字符串

### 逆波兰表达式

后缀表达式又叫做逆波兰表达式。如 `a+b` 的逆波兰表达式为 `ab+`
