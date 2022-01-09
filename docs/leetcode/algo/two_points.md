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