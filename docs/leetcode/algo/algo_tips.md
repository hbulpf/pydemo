# Python算法技巧

## 语言类

### 常用的内置函数

| 内置函数                                                     | 内置函数                                                     | 内置函数                                                     | 内置函数                                                     | 内置函数                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| [`abs()`](https://docs.python.org/zh-cn/3.7/library/functions.html#abs) | [`delattr()`](https://docs.python.org/zh-cn/3.7/library/functions.html#delattr) | [`hash()`](https://docs.python.org/zh-cn/3.7/library/functions.html#hash) | [`memoryview()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-memoryview) | [`set()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-set) |
| [`all()`](https://docs.python.org/zh-cn/3.7/library/functions.html#all) | [`dict()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-dict) | [`help()`](https://docs.python.org/zh-cn/3.7/library/functions.html#help) | [`min()`](https://docs.python.org/zh-cn/3.7/library/functions.html#min) | [`setattr()`](https://docs.python.org/zh-cn/3.7/library/functions.html#setattr) |
| [`any()`](https://docs.python.org/zh-cn/3.7/library/functions.html#any) | [`dir()`](https://docs.python.org/zh-cn/3.7/library/functions.html#dir) | [`hex()`](https://docs.python.org/zh-cn/3.7/library/functions.html#hex) | [`next()`](https://docs.python.org/zh-cn/3.7/library/functions.html#next) | [`slice()`](https://docs.python.org/zh-cn/3.7/library/functions.html#slice) |
| [`ascii()`](https://docs.python.org/zh-cn/3.7/library/functions.html#ascii) | [`divmod()`](https://docs.python.org/zh-cn/3.7/library/functions.html#divmod) | [`id()`](https://docs.python.org/zh-cn/3.7/library/functions.html#id) | [`object()`](https://docs.python.org/zh-cn/3.7/library/functions.html#object) | [`sorted()`](https://docs.python.org/zh-cn/3.7/library/functions.html#sorted) |
| [`bin()`](https://docs.python.org/zh-cn/3.7/library/functions.html#bin) | [`enumerate()`](https://docs.python.org/zh-cn/3.7/library/functions.html#enumerate) | [`input()`](https://docs.python.org/zh-cn/3.7/library/functions.html#input) | [`oct()`](https://docs.python.org/zh-cn/3.7/library/functions.html#oct) | [`staticmethod()`](https://docs.python.org/zh-cn/3.7/library/functions.html#staticmethod) |
| [`bool()`](https://docs.python.org/zh-cn/3.7/library/functions.html#bool) | [`eval()`](https://docs.python.org/zh-cn/3.7/library/functions.html#eval) | [`int()`](https://docs.python.org/zh-cn/3.7/library/functions.html#int) | [`open()`](https://docs.python.org/zh-cn/3.7/library/functions.html#open) | [`str()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-str) |
| [`breakpoint()`](https://docs.python.org/zh-cn/3.7/library/functions.html#breakpoint) | [`exec()`](https://docs.python.org/zh-cn/3.7/library/functions.html#exec) | [`isinstance()`](https://docs.python.org/zh-cn/3.7/library/functions.html#isinstance) | [`ord()`](https://docs.python.org/zh-cn/3.7/library/functions.html#ord) | [`sum()`](https://docs.python.org/zh-cn/3.7/library/functions.html#sum) |
| [`bytearray()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-bytearray) | [`filter()`](https://docs.python.org/zh-cn/3.7/library/functions.html#filter) | [`issubclass()`](https://docs.python.org/zh-cn/3.7/library/functions.html#issubclass) | [`pow()`](https://docs.python.org/zh-cn/3.7/library/functions.html#pow) | [`super()`](https://docs.python.org/zh-cn/3.7/library/functions.html#super) |
| [`bytes()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-bytes) | [`float()`](https://docs.python.org/zh-cn/3.7/library/functions.html#float) | [`iter()`](https://docs.python.org/zh-cn/3.7/library/functions.html#iter) | [`print()`](https://docs.python.org/zh-cn/3.7/library/functions.html#print) | [`tuple()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-tuple) |
| [`callable()`](https://docs.python.org/zh-cn/3.7/library/functions.html#callable) | [`format()`](https://docs.python.org/zh-cn/3.7/library/functions.html#format) | [`len()`](https://docs.python.org/zh-cn/3.7/library/functions.html#len) | [`property()`](https://docs.python.org/zh-cn/3.7/library/functions.html#property) | [`type()`](https://docs.python.org/zh-cn/3.7/library/functions.html#type) |
| [`chr()`](https://docs.python.org/zh-cn/3.7/library/functions.html#chr) | [`frozenset()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-frozenset) | [`list()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-list) | [`range()`](https://docs.python.org/zh-cn/3.7/library/functions.html#func-range) | [`vars()`](https://docs.python.org/zh-cn/3.7/library/functions.html#vars) |
| [`classmethod()`](https://docs.python.org/zh-cn/3.7/library/functions.html#classmethod) | [`getattr()`](https://docs.python.org/zh-cn/3.7/library/functions.html#getattr) | [`locals()`](https://docs.python.org/zh-cn/3.7/library/functions.html#locals) | [`repr()`](https://docs.python.org/zh-cn/3.7/library/functions.html#repr) | [`zip()`](https://docs.python.org/zh-cn/3.7/library/functions.html#zip) |
| [`compile()`](https://docs.python.org/zh-cn/3.7/library/functions.html#compile) | [`globals()`](https://docs.python.org/zh-cn/3.7/library/functions.html#globals) | [`map()`](https://docs.python.org/zh-cn/3.7/library/functions.html#map) | [`reversed()`](https://docs.python.org/zh-cn/3.7/library/functions.html#reversed) | [`__import__()`](https://docs.python.org/zh-cn/3.7/library/functions.html#__import__) |
| [`complex()`](https://docs.python.org/zh-cn/3.7/library/functions.html#complex) | [`hasattr()`](https://docs.python.org/zh-cn/3.7/library/functions.html#hasattr) | [`max()`](https://docs.python.org/zh-cn/3.7/library/functions.html#max) | [`round()`](https://docs.python.org/zh-cn/3.7/library/functions.html#round) | del 【关键字】                                               |

1. 把中文汉字、英文字母、特殊字符转换成数字。 这在算法中 常用来做 字母转成对应序号。如 a对应1,b对应2

   ```
   ord('国') #22269
   ord('A') #65
   ord('*') #42
   ```
   把数字反转为字符
   ```
   chr(70)
   chr(42)
   ```
   > 二进制：bin() 、八进制：oct() 、 十六进制：hex()
   > [全部内置函数](https://www.runoob.com/python/python-built-in-functions.html)

2. 使用map函数简化操作,例如将 str转换为int的函数:
   ```
    from functools import reduce
   
    DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
   
    def char2num(s):
        return ord(s)-ord('0')
        return DIGITS[s]
   
    def str2int(s):
        return reduce(lambda x, y: x * 10 + y, map(char2num, s))
   ```

3. 求列表最大值、最小值用 `max() ` / `min()`

4. 逆序遍历一个数字序列,可以使用 `range(start, stop[, step])` 函数
   ```
   for i in range(len(nums)-1,0,-1):
       pass
   ```

5. 用好切片，切片可以让代码十分简洁, 下面两种写法是等价的。这用于解决[旋转数组](https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/) 问题十分简洁。
   ```
   nums[:] = nums[len(nums) - k:] + nums[:len(nums) - k]
   nums[:] = nums[-k:] + nums[:-k]
   ```

6. sort() 与 sorted(): 

   - `roommate.sort()` 对list进行排序,list元素本身顺序发生改变，无返回值; 
   - `r2=sorted(roommate,reverse=True)`  对list进行排序,list本身顺序无改变，返回一个新的list


7. 要善用推导表达式

   ```
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return [nums1.pop(nums1.index(i)) for i in nums2 if i in nums1]
   ```

8. sum/max/min的使用: 都可以传入一个序列

   如果按照升序排序，那从最后一个往前取，就是降序。
   ```
   def min_scalar_prod(x, y):
       x = sorted(x)
       y = sorted(y)
       return sum(x[i] * y[-i - 1] for i in range(len(x)))
   ```

   求序列中的最小值、最大值
   ```
   tab = [22, 3, 2, 4, 21, 32]
   print(max((tab[i], i) for i in range(len(tab))))
   print(max((-tab[i], i) for i in range(len(tab))))
   print(min((tab[i], i) for i in range(len(tab))))
   #  (32, 5)
   #  (-2, 2)
   #  (2, 2)
   ```   

## 算法技巧类

1. 删除元素时会引起数组长度变化,因此**删除时从后面开始删除**可以避免此问题。

   ```python
   for k in range(left + 1, size):
   	nums.pop(-1)
   ```

   比如解决 `原地移除数组中重复元素` 问题时：

   ```python
   def removeDuplicates(self, nums: List[int]) -> int:
       """
       使用逆序删除，巧妙避开删除元素时会引起数组长度变化影响
       """
       if not nums:
           return len(nums)
       for i in range(len(nums)-1,0,-1):
           if nums[i] == nums[i-1]:
               del nums[i]
       return len(nums)
   ```
   
   如果不限制原地，还是用下面的方法
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

2. 取模 实际会形成一个环。如
    ```
    for (int i = 0; i < length; i++) {
      nums[(i + k) % length] = temp[i];
    }
    ```

3. 双指针的走动可以用一个while实现

   ```python
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        双指针
        如果数字小，就让该指针一直往下走，直到两个数相同,两个指针一起往后走。循环直到其中一个数组遍历完
        """
        nums1.sort()
        nums2.sort()
        res = []
        i = 0
        j = 0
        while i < len(nums1) and j<len(nums2):
            if nums1[i] > nums2[j]:
                j += 1
            elif nums1[i] < nums2[j]:
                i+=1
            else:
                res.append(nums1[i])
                i += 1
                j += 1
        return res
   ```

4. 两个数交换
    方法1:
    ```
    a,b=b,a
    ```
    方法2:
    ```
    a ^= b;
    b ^= a;
    a ^= b;
    ```

5. 如果要原地修改数组的值，用  `nums[:] = nums[-k:] + nums[:-k]` 而不是 ` nums = nums[-k:] + nums[:-k]`
    ```
    def rotate2(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        print(id(nums))
        nums = nums[-k:] + nums[:-k]
        print(id(nums))
    ```
    结果如下,发现修改了地址。而 `nums[:]` 没有修改。
    ```
    2381238593480
    2381238655624
    ```