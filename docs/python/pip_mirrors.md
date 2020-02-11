# pip 教程

1. [pip tutorials](https://packaging.python.org/tutorials/installing-packages/)

# pip 使用镜像源

## [清华大学 pypi 镜像使用帮助](https://mirrors.tuna.tsinghua.edu.cn/help/pypi/)
pypi 镜像每 5 分钟同步一次。

临时使用
```
pip install -i https://pypi.tuna.tsinghua.edu.cn/simple some-package
```
注意，simple 不能少, 是 https 而不是 http

设为默认
升级 pip 到最新的版本 (>=10.0.0) 后进行配置：
```
pip install pip -U
pip config set global.index-url https://pypi.tuna.tsinghua.edu.cn/simple
```
如果您到 pip 默认源的网络连接较差，临时使用清华镜像站来升级 pip：
```
pip install -i https://pypi.tuna.tsinghua.edu.cn/simple pip -U
```

注:
```bash
-i https://pypi.doubanio.com/simple/   #表示使用豆瓣源 （-i == --index-url）
--trusted-host pypi.doubanio.com       #表示添加信任

```

## pip 源

- 清华：https://pypi.tuna.tsinghua.edu.cn/simple
- 阿里云：http://mirrors.aliyun.com/pypi/simple/
- 中国科技大学 https://pypi.mirrors.ustc.edu.cn/simple/
- 华中理工大学：http://pypi.hustunique.com/
- 山东理工大学：http://pypi.sdutlinux.org/
- 豆瓣：http://pypi.douban.com/simple/

## 永久修改pip镜像源

### Linux系统

Linux下，修改 ~/.pip/pip.conf (没有就创建一个文件夹及文件)

内容如下：
```
[global]
index-url = https://pypi.tuna.tsinghua.edu.cn/simple

[install]
trusted-host=mirrors.aliyun.com
```

### windows系统
windows下，直接在user目录中创建一个pip目录，如：C:\Users\xx\pip，新建文件pip.ini。内容与上边类似。具体如下：

(1)在windows文件管理器中,输入 %APPDATA% , 会定位到一个新的目录下

(2)在该目录下新建pip文件夹，到pip文件夹里面去新建个pip.ini文件

(3):在新建的pip.ini文件中输入以下内容，搞定文件路径："C:\Users\Administrator\AppData\Roaming\pip\pip.ini"
```
[global]
timeout = 6000
index-url = https://pypi.tuna.tsinghua.edu.cn/simple
trusted-host =mirrors.aliyun.com
```

