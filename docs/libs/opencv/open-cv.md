# open-cv

cv2和PIL.Image之间的转换
https://blog.csdn.net/qq_38153833/article/details/88060268

cv2.imread与Image.open打开图片格式的不同与调整
https://blog.csdn.net/sinat_36391198/article/details/103313250


cv2.cvtColor(img,p)图片格式转换的用法

cv2.cvtColor(img,p)
功能：颜色空间转换
参数：img：需要转换的图片
　　　p：转换成何种格式。
　　　　　p=cv2.COLOR_BGR2RGB :BGR格式转换成RGB格式
　　　　　p=cv2.COLOR_BGR2GRAY :BGR格式转换成灰度图片
返回值：颜色空间转换后的图片矩阵
