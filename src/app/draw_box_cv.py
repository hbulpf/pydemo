#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/7/4 12:16
@Author: RunAtWorld
@File: draw_box_cv.py
@Project: PyCharm
"""

import cv2


def draw():
    image_path = './taxi.jpg'
    img = cv2.imread(image_path)
    # 左上(X,Y)
    pt1 = (341, 718)
    # 右下(X,Y)
    pt2 = (341 + 342, 718 + 201)
    cv2.rectangle(img, pt1, pt2, (0, 255, 0), 2)
    # 类别名称
    object_type = 'taxi'
    # 置信度
    credence = 0.596
    # 定义字体
    font = cv2.FONT_HERSHEY_SIMPLEX
    # 打标签: 文字内容, 左上角坐标,字体,大小,颜色,字体厚度
    cv2.putText(img, '{} {:.3f}'.format(object_type, credence), (341 + 50, 718 - 15), font, 1, (0, 0, 255), 2)
    cv2.imwrite('./res/taxi-cv.jpg', img)


if __name__ == '__main__':
    draw()
