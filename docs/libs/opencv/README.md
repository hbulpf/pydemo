# open-cv

安装 
```
pip install opencv-python==3.4.15.55  # 安装opencv
opencv-contrib-python==3.4.15.55  # 安装opencv扩展工具包
```

[官方手册](https://docs.opencv.org/3.4.15/d9/df8/tutorial_root.html)

## 核心函数

### 图像基本操作
#### 读入图片
读入彩图,默认读入格式为BGR
```
img=cv2.imread("图片路径")
print(img.shape)
print(img)
```
shape 为 (560, 700, 3), 对应 (height,width,deepth)

读入灰度图
```
r_img=cv2.imread("图片路径",cv2.IMREAD_GRAYSCALE)
```

查看属性
```
print(f'type:{type(img)}, size:{img.size}, dtype:{img.dtype}')
print(f'type:{type(r_img)}, size:{r_img.size}, dtype:{r_img.dtype}')
```

结果为
```
type:<class 'numpy.ndarray'>, size:1176000, dtype:uint8
type:<class 'numpy.ndarray'>, size:392000, dtype:uint8
```


##### 显示图片

显示图片
```
cv2.imshow('猫',img)
cv2.waitKey(1000) #显示1秒,0表示任意键终止
cv2.destroyAllWindows()
```



##### 保存图片
```
cv2.imwrite('img/res/r_taxi.jpg',img)
```


#### 读入视频

```
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
```

## ROI 截取部分图像

```
import cv2
gimg=cv2.imread("cat.jpg", cv2.IMREAD_GRAYSCALE)
cat = gimg[0:50,0:200] #截取ROI
cv2.imshow('cat',cat)
cv2.waitKey(1000)  # 显示1秒
cv2.destroyAllWindows()
```

## 通道提取

方法1:

```
b,g,r = cv2.split(img)
print(f'shape: {b.shape}  b:{b}')
```

方法2:

```
g = img[:,:,1]
print(f'shape: {g.shape}  g:{g}')
```


