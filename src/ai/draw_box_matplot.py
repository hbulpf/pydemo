#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/7/4 12:17
@Author: RunAtWorld
@File: draw_box_matplot.py
@Project: PyCharm
"""

import cv2
from PIL import Image, ImageFont
from PIL import ImageDraw


def draw():
    file_name = 'taxi.jpg'
    img = Image.open(file_name)
    drawer = ImageDraw.ImageDraw(img)
    # 左上(X,Y)
    pt1 = (341, 718)
    # 右下(X,Y)
    pt2 = (341 + 342, 718 + 201)
    # 画框: 在边界框的两点（左上角、右下角）画矩形，无填充，边框红色，边框像素为5
    drawer.rectangle((pt1, pt2), fill=None, outline='red', width=3)
    # 类别名称
    object_type = 'taxi'
    # 置信度
    credence = 0.596
    # 定义字体

    font = ImageFont.truetype(r'C:\Windows\Fonts\Arial.ttf', 36)
    drawer.text((341 + 50, 718 - 40), '{} {:.3f}'.format(object_type, credence), (255, 0, 0), font=font)

    pic_drew_path = "res/taxi-pil.jpg"
    img.save(pic_drew_path)
    cv2.imshow('image', cv2.imread(pic_drew_path))
    cv2.waitKey(0)


if __name__ == '__main__':
    draw()
