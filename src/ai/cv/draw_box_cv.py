#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/7/4 12:16
@Author: RunAtWorld
@File: draw_box_cv.py
@Project: PyCharm
"""
import base64
import json

import cv2
import numpy as np


def draw():
    image_path = 'img/taxi.jpg'
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
    cv2.imwrite('img/res/taxi-cv.jpg', img)


def overlay():
    # load the image
    image = cv2.imread("img/taxi.jpg")
    # 左上(X,Y)
    pt1 = (341, 718)
    # 右下(X,Y)
    pt2 = (341 + 342, 718 + 201)

    # loop over the alpha transparency values
    for alpha in np.arange(0, 1.2, 0.3)[::-1]:
        # create two copies of the original image -- one for
        # the overlay and one for the final output image
        overlay = image.copy()
        output = image.copy()
        # draw a green rectangle surrounding kobe'hand in the image
        # along with the text "PyImageSearch" at the top-left
        # corner
        cv2.rectangle(overlay, pt1, pt2, (0, 255, 0), -1)
        # cv2.putText(overlay, "alpha={}".format(alpha), (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 1.0, (0, 0, 255), 3)
        # apply the overlay
        cv2.addWeighted(overlay, alpha, output, 1 - alpha, 0, output)
        # show the output image
        print("alpha={}, beta={}".format(alpha, 1 - alpha))
        cv2.imshow("Output", output)
        cv2.waitKey(0)
        cv2.imwrite("res/alpha={}.jpg".format(alpha), output)


def resize_test():
    import cv2 as cv
    # 读入原图片
    img = cv.imread('img/taxi.jpg')
    # 打印出图片尺寸
    print(img.shape)
    # 将图片高和宽分别赋值给x，y
    x, y = img.shape[0:2]
    # 显示原图
    cv.imshow('OriginalPicture', img)
    # 缩放到原来的二分之一，输出尺寸格式为（宽，高）
    img_test1 = cv.resize(img, (int(y / 2), int(x / 2)))
    cv.imshow('original 1/2', img_test1)
    cv.waitKey()
    # 最近邻插值法缩放
    # 缩放到原来的四分之一
    img_test2 = cv.resize(img, (0, 0), fx=0.25, fy=0.25, interpolation=cv.INTER_NEAREST)
    cv.imshow('original 1/4', img_test2)
    cv.waitKey()
    cv.destroyAllWindows()


def overlay_blob():
    image = cv2.imread("img/unetpp-yt.jpg")
    h, w = image.shape[0:2]
    print(image.shape)
    contours = cv2.imread("img/BlobContours.jpg")
    h1, w1 = contours.shape[0:2]
    fh, fw = (h / h1), (w / w1)
    print(f"{fw},{fh}")
    # overlayer = cv2.resize(contours, (w, h))
    overlayer = cv2.resize(contours, (0, 0), fx=fw, fy=fh, interpolation=cv2.INTER_NEAREST)
    output = image.copy()
    alpha = 0.2
    cv2.addWeighted(overlayer, alpha, image, 1 - alpha, 0, output)
    # cv2.resize(output, (h, w))
    cv2.imshow('output', output)
    cv2.waitKey()
    cv2.destroyAllWindows()


def str2jpg(str, img):
    with open(img, "wb") as f:
        bi = base64.b64decode(str)
        f.write(bi)


def json2jpg():
    with open("img/unet++-WithoutReg-rsp.json", "r") as f:
        json1 = json.loads(f.read())
        BlobContours = json1.get("reqs/unetpp-yt.jpg").get("BlobContours")
        print("BlobContours: " + BlobContours)
        BlobMask = json1.get("reqs/unetpp-yt.jpg").get("BlobMask")
        print("BlobMask:" + BlobMask)
        img1 = "img/BlobContours.jpg"
        str2jpg(BlobContours, img1)
        img2 = "img/BlobMask.jpg"
        str2jpg(BlobMask, img2)


def fill():
    """
    python+OpenCV填充孔洞
    https://zhuanlan.zhihu.com/p/63919290
    :return:
    """
    pass


if __name__ == '__main__':
    # draw()
    # overlay()
    # json2jpg()
    # resize_test()
    overlay_blob()
