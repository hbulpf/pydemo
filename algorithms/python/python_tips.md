# Python算法技巧



## 语言类

### 常用的内置函数

| 内置函数                                                     | 内置函数                                                     | 内置函数                                                     | 内置函数                                                     | 内置函数                                                     |
| :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| [abs()](https://www.runoob.com/python3/python3-func-number-abs.html) | [dict()](https://www.runoob.com/python/python-func-dict.html) | [help()](https://www.runoob.com/python/python-func-help.html) | [min()](https://www.runoob.com/python3/python3-func-number-min.html) | [setattr()](https://www.runoob.com/python/python-func-setattr.html) |
| [all()](https://www.runoob.com/python/python-func-all.html)  | [dir()](https://www.runoob.com/python/python-func-dir.html)  | [hex()](https://www.runoob.com/python3/python3-func-hex.html) | [next()](https://www.runoob.com/python/python-func-next.html) | [slice()](https://www.runoob.com/python/python-func-slice.html) |
| [any()](https://www.runoob.com/python/python-func-any.html)  | [divmod()](https://www.runoob.com/python3/python3-func-divmod.html) | [id()](https://www.runoob.com/python/python-func-id.html)    | object()                                                     | [sorted()](https://www.runoob.com/python3/python3-func-sorted.html) |
| [ascii()](https://www.runoob.com/python3/python3-func-ascii.html) | [enumerate()](https://www.runoob.com/python3/python3-func-enumerate.html) | [input()](https://www.runoob.com/python/python3-func-input.html) | [oct()](https://www.runoob.com/python/python3-func-oct.html) | [staticmethod()](https://www.runoob.com/python/python-func-staticmethod.html) |
| [bin()](https://www.runoob.com/python/python-func-bin.html)  | [eval()](https://www.runoob.com/python/python-func-eval.html) | [int()](https://www.runoob.com/python/python-func-int.html)  | [open()](https://www.runoob.com/python3/python3-func-open.html) | [str()](https://www.runoob.com/python/python-func-str.html)  |
| [bool()](https://www.runoob.com/python/python-func-bool.html) | [exec()](https://www.runoob.com/python3/python3-func-exec.html) | [isinstance()](https://www.runoob.com/python/python-func-isinstance.html) | [ord()](https://www.runoob.com/python3/python3-func-ord.html) | [sum()](https://www.runoob.com/python/python-func-sum.html)  |
| [bytearray()](https://www.runoob.com/python/python-func-bytearray.html) | [filter()](https://www.runoob.com/python3/python3-func-filter.html) | [issubclass()](https://www.runoob.com/python/python-func-issubclass.html) | [pow()](https://www.runoob.com/python3/python3-func-number-pow.html) | [super()](https://www.runoob.com/python/python-func-super.html) |
| [bytes()](https://www.runoob.com/python3/python3-func-bytes.html) | [float()](https://www.runoob.com/python/python-func-float.html) | [iter()](https://www.runoob.com/python/python-func-iter.html) | [print()](https://www.runoob.com/python/python-func-print.html) | [tuple()](https://www.runoob.com/python3/python3-func-tuple.html) |
| [callable()](https://www.runoob.com/python/python-func-callable.html) | [format()](https://www.runoob.com/python/att-string-format.html) | [len()](https://www.runoob.com/python3/python3-string-len.html) | [property()](https://www.runoob.com/python/python-func-property.html) | [type()](https://www.runoob.com/python/python-func-type.html) |
| [chr()](https://www.runoob.com/python3/python3-func-chr.html) | [frozenset()](https://www.runoob.com/python/python-func-frozenset.html) | [list()](https://www.runoob.com/python3/python3-att-list-list.html) | [range()](https://www.runoob.com/python3/python3-func-range.html) | [vars()](https://www.runoob.com/python/python-func-vars.html) |
| [classmethod()](https://www.runoob.com/python/python-func-classmethod.html) | [getattr()](https://www.runoob.com/python/python-func-getattr.html) | [locals()](https://www.runoob.com/python/python-func-locals.html) | [repr()](https://www.runoob.com/python/python-func-repr.html) | [zip()](https://www.runoob.com/python3/python3-func-zip.html) |
| [compile()](https://www.runoob.com/python/python-func-compile.html) | [globals()](https://www.runoob.com/python/python-func-globals.html) | [map()](https://www.runoob.com/python/python3-func-map.html) | [reversed()](https://www.runoob.com/python3/python3-func-reversed.html) | [__import__()](https://www.runoob.com/python/python-func-__import__.html) |
| [complex()](https://www.runoob.com/python/python-func-complex.html) | [hasattr()](https://www.runoob.com/python/python-func-hasattr.html) | [max()](https://www.runoob.com/python3/python3-func-number-max.html) | [round()](https://www.runoob.com/python3/python3-func-number-round.html) | del 【关键字】                                               |
| [delattr()](https://www.runoob.com/python/python-func-delattr.html) | [hash()](https://www.runoob.com/python/python-func-hash.html) | [memoryview()](https://www.runoob.com/python/python-func-memoryview.html) | [set()](https://www.runoob.com/python/python-func-set.html)  |                                                              |

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
