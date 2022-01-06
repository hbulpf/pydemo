#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2022/1/6 16:42
@Author: RunAtWorld
@File: use_excel.py
"""

import xlrd

def read_trans_excel():
    #文件名以及路径，如果路径或者文件名有中文给前面加一个 r
    file_path = r'E:\atlas\hw_docs\opt\1230\视觉软件中文界面词-en.xlsx'
    data = xlrd.open_workbook(file_path)
    names = data.sheet_names()
    print(names)
    table = data.sheets()[0]
    # 获取表格行数
    nrows = table.nrows
    print("表格一共有",nrows,"行")

    # 获取第3行第2列表格值 (2,1)
    value = table.cell_value(2, 1)
    print("第3行2列值为",value)

    # 获取第2,3列所有值
    name_list = [(str(table.cell_value(i, 1)),str(table.cell_value(i, 2))) for i in range(0, nrows)]
    print("第2,3列所有的值：",name_list)

def generate_qt_ts():
    file_path = r'./files/en.ts'

if __name__ == '__main__':
    read_trans_excel()