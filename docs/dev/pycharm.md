# PyCharm

## PyCharm使用指导

参考 [PyCharm使用指导](https://jetbrains.com.zh.xy2401.com/help/pycharm/)

## cmd进入pycharm所创建的虚拟环境

打开pycharm的 `File | Settings | Project: mysite | Project Interpreter`
进入cmd命令，进入虚拟环境所在文件夹。（pycharm每创建一个新项目就会创建一个虚拟环境，位于项目下venv下Script）

```
E:\virtualenv\crawl1\Scripts>activate
```

（这里E:\virtualenv\crawl1\是虚拟环境所在文件夹，Scripts是crawl1下的文件夹，这个文件夹里有activate激活组件）

## 代码模板

file -->settings–>editor–>file and code templates

```
#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : ${DATE} ${TIME}
@Author: ${USER}
@File: ${NAME}.py
@Project: ${PRODUCT_NAME}
"""
```

其他

```
${PROJECT_NAME} - 当前Project名称; (the name of the current project. )
${NAME} -创建文件的对话框中制定的文件名; (the name of the new file which you specify in the New File dialog box during the file creation. )
${USER} - 当前用户名; the login name of the current user.
${DATE} - 当前系统日期; the current system date.
${TIME} - 当前系统时间; the current system time.
${YEAR} - 年; the current year.
${MONTH} - 月; the current month.
${DAY} - 日; the current day of the month.
${HOUR} - 小时; the current hour.
${MINUTE} - 分钟; the current minute.
${PRODUCT_NAME} - 创建文件的IDE名称; the name of the IDE in which the file will be created.
${MONTH_NAME_SHORT} - 英文月份缩写; the first 3 letters of the month name. Example: Jan, Feb, etc.
${MONTH_NAME_FULL} - 英文月份全称; full name of a month. Example: January, February, etc.
```