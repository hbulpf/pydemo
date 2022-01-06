# Excel


## 参考
1. [Python 自动化操作 Excel 看这一篇就够了](https://zhuanlan.zhihu.com/p/259583430)
2. [python如何处理excel数据](https://www.php.cn/python-tutorials-415669.html)

## FAQ
1. 在运用python中xlrd库读取.xlsx文件时报错，无法读取。
   
    ```
    xlrd.biffh.XLRDError: Excel xlsx file； not supported
    ```

    在运用python中xlrd库读取.xlsx文件时报错，无法读取。这是由于当前python中的xlrd版本过高导致的，高版本下删除的对应的.xlsx读取方法。因此，只需要重装xlrd即可，win+R打开cmd，输入下文，即可解决该问题
    ```
    pip3 install xlrd==1.2.0
    ```