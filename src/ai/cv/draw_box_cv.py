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
    blobMask="iVBORw0KGgoAAAANSUhEUgAAAQAAAADACAAAAADOhuK6AAACOElEQVR4AeXBQa6cMBRFwXMw7H/BYBL1R0pg1rYy4OVWSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTv4Ff1GVhJNwEk7CyZwFOPkPyJSFj5P6ZMrCx0l9MmXhx0l5MmPhclKezFi4nJQnUxZ+nJQnUxY+TuqTOQuc/A8knISTcBJOwkk4CSfhJJyEk3ASTsJJOBnW+KszZAUOXkVGNe46A1Y+Dt5ERjUeOl9b+XHwJjKq8dD52srl4EVkVOOh87WVy8GLyKjGQ+drK5eDF5FRjYfO11YuBy8ioxoPna+tXA5eREY1HjrfW/k4eBMZ1bjrDFk5eBcZ1bjrFCejGned4mRU465TnIxq3HWKk1GNm051Mqhx16lOBjUeOsXJoMZDpzgZ1HjoFCeDGg+d4mRQ46FTnAxq3HWqk1GNm051MqzxR6c8mdSATn0STsLJtA3YqU5mbXzsFCeTNn7sFCeTNi47tcmkjctObTJp47JTm0zauOzUJrM2PnaKk2kbsFOdhJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyE+w0wTDbBzcjKhQAAAABJRU5ErkJggg=="
    base64_to_img(blobMask, "blobmask.jpg")

def draw_blobContours():
    blobContours="iVBORw0KGgoAAAANSUhEUgAAAQAAAADACAAAAADOhuK6AAAC9UlEQVR4AeXBPWHkSBRG0XsZiIAQKCkiExuj2VQiBCIgCPu83fb8bNKldaCa7xwJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3DyHd7emZV8gzd4Z1Ly/71R3pmTfIM3eGdS8h3e3pmVXLMBO38BuWTjw8785IqNh53pyQUbn3ZmJxdsfNqZnVywUfaNsjM5GbdRdjbKzuRk3EbZ2Sg7k5MLNr7sTE4u2Pi0Mzu5YuNhZ3pyycaHnfnJNRvs/A0knISTcBJOwkk4CSfhJJyEk2GdnxpDFuDkVmRU51eNAQsfTu5EBnV+13jZwsPJjciYzp8aL1r4dHIfMqbzH42XLHw5uQ8Z0ymNp05pvGShnCyUk9uQMZ3SeOqUxksWyslCObkNGdMpjadOabxkoZwslJPbkDGd0njqlMZLFsrJQjm5DRnTKY2nTmm8ZOGnk9uQMZ3SeOqUxmsWPp3ch4zplMZDpzRetfBwciMyplMaD53SeNnCh5M7kTGd0njolMaAhZN7kTGd0njolMbUZEynNB46pTE1GdMpjX91SmNuMqRTGg+d0pibDOmUxlOnNKYmQzql8dQpjanJkE5pPHVKY2oypFMaT53SmJoM6ZTGU6c0piZDOp8adEpjbjKm84fG3GRQ5zeNycmozi8as5NhnS8/DmYnF3XgBxxMTi5aeTiYm1yz8ulganLJypeDqcklK+VgpRzMTC5ZKQcr5WBmcslKOVgpBzOTS1Z+OpiZXLPy6WBqctHKw8Hc5KqVDweTk8tW4GB2Ek7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyEk3ASTsJJOAkn4SSchJNwEk7CSTgJJ+EknISTcBJOwkk4CSfhJJyE+wdDLmfBudbLjwAAAABJRU5ErkJggg=="
    base64_to_img(blobContours, "blobContours.jpg")

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
