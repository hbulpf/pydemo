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
from PIL import Image
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


def str2jpg(str, img):
    with open(img, "wb") as f:
        bi = base64.b64decode(str)
        f.write(bi)


def str2cv2jpg(str):
    bi = base64.b64decode(str)
    # 二进制数据流转np.ndarray [np.uint8: 8位像素]
    img = cv2.imdecode(np.frombuffer(bi, np.uint8), cv2.IMREAD_COLOR)
    # # 将bgr转为rbg
    rgb_img = cv2.cvtColor(img, cv2.COLOR_RGB2BGR)
    cv2.imwrite("img/res/str2cv2.jpg", rgb_img)


def json2jpg():
    with open("img/unet++-WithoutReg-rsp.json", "r") as f:
        json1 = json.loads(f.read())
        BlobContours = json1.get("reqs/unetpp-yt.jpg").get("BlobContours")
        print("BlobContours: " + BlobContours)
        img1 = "img/res/BlobContours.jpg"
        str2jpg(BlobContours, img1)
        str2cv2jpg(BlobContours)


def fill_color(img, save_path):
    """
    PYTHON---二值图像连通域标记
    https://www.freesion.com/article/5478444052/
    :return:
    """
    width = img.size[0]
    height = img.size[1]

    # 定位一个种子,返回种子位置
    def seed_dirt():
        for j in range(height):
            for i in range(width):
                a = img.getpixel((i, j))
                if a == 0:
                    return i, j
        print('no seed')

    # 标记连通区域-4连通
    def LableConnectedRagion4(labelmap, labelindex, quene):
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

    # 匹配标记矩阵输出第一个连通域图片
    def save_image(label_map):
        for i in range(len(label_map)):
            for j in range(len(label_map[0])):
                if label_map[i][j] != 0:
                    new_img.putpixel((j, i), 0)
        new_img.save(save_path)

    # img = img.convert('1')
    new_img = Image.new("1", (width, height), 255)
    label_map = np.zeros((height, width))
    label_index = 0
    queue = []
    (x, y) = seed_dirt()
    queue.append((x, y))
    label_index += 1
    label_map[y][x] = 1
    LableConnectedRagion4(label_map, label_index, queue)
    save_image(label_map)


def draw_seg():
    def get_blob_contours():
        with open("img/unet++-WithoutReg-rsp.json", "r") as f:
            json1 = json.loads(f.read())
            return json1.get("reqs/unetpp-yt.jpg").get("BlobContours")

    def overlay_blob(pic_path, contours_path, save_path):
        image = cv2.imread(pic_path)
        h, w = image.shape[0:2]
        contours = cv2.imread(contours_path)
        h1, w1 = contours.shape[0:2]
        fh, fw = (h / h1), (w / w1)
        print(f"{fw},{fh}")
        overlayer = cv2.resize(contours, (0, 0), fx=fw, fy=fh, interpolation=cv2.INTER_NEAREST)
        output = image.copy()
        alpha = 0.3
        cv2.addWeighted(overlayer, alpha, image, 1 - alpha, 0, output)
        cv2.imwrite(save_path, output)

    pic_path = 'img/unetpp-yt.jpg'
    contours_path = "img/res/unet_contours.jpg"
    save_path = "img/res/unet_res.jpg"
    blob_contours = get_blob_contours()
    bi = base64.b64decode(blob_contours)
    # 二进制数据流转np.ndarray [np.uint8: 8位像素]
    img = cv2.imdecode(np.frombuffer(bi, np.uint8), cv2.IMREAD_COLOR)
    rgb_img = Image.fromarray(cv2.cvtColor(img, cv2.COLOR_BGR2GRAY))
    fill_color(rgb_img, contours_path)
    overlay_blob(pic_path, contours_path, save_path)

def base64_to_img(bstr, file_path):
    import base64
    imgdata = base64.b64decode(bstr)
    file = open(file_path, 'wb')
    file.write(imgdata)
    file.close()

def draw_blobMask():
    blobMask="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"
    base64_to_img(blobMask, "1.jpg")

def draw_blobContours():
    blobContours="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"
    base64_to_img(blobContours, "2.jpg")

if __name__ == '__main__':
    # draw()
    # overlay()
    # json2jpg()
    # resize_test()
    # overlay_blob("img/unetpp-yt.jpg", "img/BlobContours.jpg")
    # fill_color("img/BlobContours.jpg")PIL.PngImagePlugin.PngImageFile
    # json2jpg()
    # draw_seg()
    draw_blobMask()
    draw_blobContours()
