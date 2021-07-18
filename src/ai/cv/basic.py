#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/7/18 16:28
@Author: RunAtWorld
@File: basic.py
@Project: PyCharm
"""

import cv2
import numpy as np


# import matplotlib.pyplot as plt


def read_img():
    img = cv2.imread('img/taxi.jpg')
    print(img.shape)
    print(img)
    cv2.imshow('车', img)
    cv2.waitKey(0)  # 任意键退出
    cv2.imwrite('img/res/res_taxi.jpg', img)
    cv2.destroyAllWindows()

    r_img = cv2.imread('img/taxi.jpg', cv2.IMREAD_GRAYSCALE)
    print(r_img.shape)
    print(r_img)
    cv2.imshow('车', r_img)
    cv2.waitKey(1000)  # 显示1秒
    cv2.imwrite('img/res/r_taxi.jpg', r_img)
    cv2.destroyAllWindows()


def read_video():
    vc = cv2.VideoCapture('E:/tmp/test.mp4')
    if vc.isOpened():
        open_ok, frame = vc.read()
    else:
        open_ok = False
    while open_ok:
        ret, frame = vc.read()
        if frame is None:
            break
        if ret:
            # 灰度显示
            gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
            cv2.imshow('res', gray)
            # 指定27的退出键作为退出
            if cv2.waitKey(10) & 0xFF == 27:
                break
    vc.release()
    cv2.destroyAllWindows()


if __name__ == '__main__':
    read_video()
