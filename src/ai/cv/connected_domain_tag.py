#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/7/18 0:13
@Author: RunAtWorld
@File: connected_domain_tag.py
@Project: PyCharm
"""
import numpy as np
from PIL import Image


# img = Image.open('img/taxi.jpg')
#
# # 模式L”为灰色图像，它的每个像素用8个bit表示，0表示黑，255表示白，其他数字表示不同的灰度。
# Img = img.convert('L')
# Img.save("img/res/taxi-cdt.jpg")
#
# # 自定义灰度界限，大于这个值为黑色，小于这个值为白色
# threshold = 200
#
# table = []
# for i in range(256):
#     if i < threshold:
#         table.append(0)
#     else:
#         table.append(1)
#
# # 图片二值化
# photo = Img.point(table, '1')
# photo.save("img/res/taxi-1.jpg")


# 定位一个种子,返回种子位置
def seed_dirt(img):
    for j in range(height):
        for i in range(width):
            a = img.getpixel((i, j))
            if a == 0:
                return ((i, j))


# 标记连通区域-4连通
def LableConnectedRagion4(labelmap, labelindex, quene):
    # flag = len(quene)
    while len(quene) != 0:
        (m, n) = quene[0]
        quene.remove(quene[0])
        if img.getpixel((m, n + 1)) == 0 and labelmap[n + 1][m] == 0:
            quene.append((m, n + 1))
            labelindex += 1
            labelmap[n + 1][m] = 1
        if img.getpixel((m, n - 1)) == 0 and labelmap[n - 1][m] == 0:
            quene.append((m, n - 1))
            labelindex += 1
            labelmap[n - 1][m] = 1
        if img.getpixel((m + 1, n)) == 0 and labelmap[n][m + 1] == 0:
            quene.append((m + 1, n))
            labelindex += 1
            labelmap[n][m + 1] = 1
        if img.getpixel((m - 1, n)) == 0 and labelmap[n][m - 1] == 0:
            quene.append((m - 1, n))
            labelindex += 1
            labelmap[n][m - 1] = 1


# 标记连通区域-8连通
def LableConnectedRagion8(labelmap, labelindex, quene):
    # flag = len(quene)
    while len(quene) != 0:
        (m, n) = quene[0]
        quene.remove(quene[0])
        # print(m,n)
        # print(quene)
        for i in range(-1, 2):
            for j in range(-1, 2):
                if img.getpixel((m + i, n + j)) == 0 and labelmap[n + j][m + i] == 0:
                    quene.append((m + i, n + j))
                    labelindex += 1
                    labelmap[n + j][m + i] = 1


# 匹配标记矩阵输出第一个连通域图片
def save_image(labelmap):
    for i in range(len(labelmap)):
        for j in range(len(labelmap[0])):
            if labelmap[i][j] != 0:
                newImg.putpixel((j, i), 0)
    # newImg.show()
    newImg.save("img/res/BlobContours_res.jpg")


if __name__ == "__main__":
    img = Image.open('img/res/str2cv2.jpg')
    # img = img.convert('1')

    width = img.size[0]
    height = img.size[1]
    print(width, height)

    # 新建图片newImg储存两图片相加图片
    newImg = Image.new("1", (width, height), 255)

    labelmap = np.zeros((height, width))  # 标记矩阵
    labelindex = 0  # 标记记数
    quene = []  # 存储标记点位置信息

    (x, y) = seed_dirt(img)
    quene.append((x, y))
    labelindex += 1
    labelmap[y][x] = 1

    LableConnectedRagion4(labelmap, labelindex, quene)
    save_image(labelmap)
