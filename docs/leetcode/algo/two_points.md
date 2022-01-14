# 双指针

1. 要观察数据的特征,利用题目中的条件
   
## 简单

> [力扣977. 有序数组的平方](https://leetcode-cn.com/problems/squares-of-a-sorted-array/)

```
def sortedSquares(self, nums: List[int]) -> List[int]:
    """
    要利用「数组 nums 已经按照升序排序」这个条件,同时 前面半部分是负数，后面半部分时正数
    使用两个指针分别指向位置 0 和 n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针
    """
    lo = 0
    hi = len(nums) - 1
    ans = [0] * len(nums)
    i = hi
    while lo <= hi:
        if nums[lo] ** 2 > nums[hi] ** 2:
            ans[i] = nums[lo] ** 2
            lo += 1
        else:
            ans[i] = nums[hi] ** 2
            hi -= 1
        i -= 1
    return ans
```        

> [力扣283. 移动零](https://leetcode-cn.com/problems/move-zeroes/submissions/)

## 双指针操作链表

双指针操作链表，有时十分考验编程技巧。

如果 [力扣 19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/) 就十分考验编程技巧。
a. 双指针直接想法 难点在于临界值的选择控制。这种通常不好找(也能找)。尤其是当需要删除的接点是head时更难处理。
b. 构造头结点: 构造一个虚拟的头节点dummy,代替head。这是一个比较好的思路:
使快指针走到 n+1的位置，这样与慢节点就相差 n+1个节点;
快节点走到最后，即 len+1位置，慢节点走到 len-n 位置，即倒数第n个节点前一个。