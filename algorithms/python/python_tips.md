# Python算法技巧

## 语言类

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

## 算法技巧类

