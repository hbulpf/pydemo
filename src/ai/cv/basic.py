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
    :param src_path: 图片路径
    :param dest_path: 目标输出路径
    :return:
    """
    if not is_allowed_file(src_path):
        print(f"pic({src_path}) is not pic!")
        return
    img1 = cv2.imread(src_path)
    g = img1[:, :, 1]
    cv2.imwrite(dest_path, img1)
    cv2.destroyAllWindows()


def is_allowed_file(pic_path):
    """
    检查文件后缀名
    :param pic_path: 图片路径
    :return: 是否为符合要求的图片
    """
    file_suffix = {'.jpg', '.jpeg', '.png'}
    suffix_ok = False
    for suffix in file_suffix:
        if pic_path.endswith(suffix):
            suffix_ok = True
            break
    return suffix_ok


def get_single_chan_dir(src_dir, dest_dir):
    """
    提取某个目录下面图片的g通道
    :param src_dir: 原始图片目录
    :param dest_dir: 目标输出目录
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


def split_pic(src_path, dest_dir, row_num=2, col_num=2, need_gray_convertion=False):
    """
    对图片进行切分
    :param src_path: 图片路径
    :param dest_dir: 目标输出目录
    :param row_num: 横向切分数目
    :param col_num: 纵向切分数目
    :param need_gray_convertion: 是否需要转换为灰度模式
    :return:
    """
    if not os.path.exists(src_path):
        print(f"{src_path} not exists")
        return
    if need_gray_convertion:
        img = cv2.imread(src_path, cv2.IMREAD_GRAYSCALE)
        height, width = img.shape
    else:
        img = cv2.imread(src_path)
        height, width, _ = img.shape
    print(f"pic shape: {img.shape}")
    if not os.path.isdir(dest_dir):
        os.makedirs(dest_dir)
    piece_w = int(width / row_num)
    piece_h = int(height / col_num)
    pic_name_ext = os.path.split(src_path)[1]
    pic_name = os.path.splitext(pic_name_ext)[0]
    pic_ext_name = os.path.splitext(pic_name_ext)[1]
    for i in range(row_num):
        for j in range(col_num):
            piece = img[piece_h * j: piece_h * (j + 1), piece_w * i:piece_w * (i + 1)]
            print(f"piece shape:{piece.shape}")
            piece_name = "{}-{}_{}{}".format(pic_name, i + 1, j + 1, pic_ext_name)
            print(f"get piece({piece_name})")
            cv2.imwrite(os.path.join(dest_dir, piece_name), piece)
    print(f"finished to split pic({src_path}) to {row_num}*{col_num} slices")
    cv2.destroyAllWindows()


if __name__ == '__main__':
    # read_video()
    # get_single_chan_dir('./img', './img_tmp')
    split_pic('./img/taxi1.jpg', 'img_tmp/', need_gray_convertion=True)