#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/7/18 16:28
@Author: RunAtWorld
@File: basic.py
@Project: PyCharm
"""
import os

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


def get_single_chan(src_path, dest_path):
    """
    提取图片g通道
    :param src_path:
    :param dest_path:
    :return:
    """
    img1 = cv2.imread(src_path)
    if not is_allowed_file(src_path):
        print(f"pic({src_path}) is not pic!")
        return
    g = img1[:, :, 1]
    cv2.imwrite(dest_path, g)
    cv2.destroyAllWindows()


def is_allowed_file(src_path):
    """
    检查文件后缀名
    :param src_path:
    :return:
    """
    file_suffix = {'.jpg', '.jpeg', '.png'}
    suffix_ok = False
    for suffix in file_suffix:
        if src_path.endswith(suffix):
            suffix_ok = True
            break
    return suffix_ok


def get_single_chan_dir(src_dir, dest_dir):
    """
    提取某个目录下面图片的g通道
    :param src_dir:
    :param dest_dir:
    :return:
    """
    if not os.path.isdir(src_dir):
        print(f"{src_dir} not exists")
    if not os.path.isdir(dest_dir):
        os.makedirs(dest_dir)
    for fi in os.listdir(src_dir):
        f_src = os.path.join(src_dir, fi)
        f_dest = os.path.join(dest_dir, fi)
        get_single_chan(f_src, f_dest)
    print(f"finished to convert pic to g channel from src({src_dir}) to dest({dest_dir})")


if __name__ == '__main__':
    # read_video()
    get_single_chan_dir('./img', './img_tmp')
