# pip教程

在Python中，安装第三方模块，是通过包管理工具pip完成的。 

一般来说，第三方库都会在Python官方的[pypi.python.org](https://pypi.python.org/)网站注册 

如果尚未安装pip，参考[安装Python](https://www.liaoxuefeng.com/wiki/1016959663602400/1016959856222624), 确保安装时勾选了`pip`和`Add python.exe to Path`。 pip的详细教程见 [pip tutorials](https://packaging.python.org/tutorials/installing-packages/)

# pip 常用命令

## 基础命令
```
# 查看 pip 版本信息
pip -V

# 安装/卸载包
pip install/uninstall pyspark

# 查看可安装包的版本
pip install pyspark==

# 查看已安装的包
pip list

# 查看已安装包的信息，这里面比较有用的就是版本信息（吐槽下 Python 是经常因为包的版本不对导致一些奇怪的问题）
pip show pyspark

# 检查包的依赖项
pip check pyspark

# 以 requirements 的格式输出已安装的包
# 这个命令可以用于辅助下载已安装的包，然后到另一台机器离线安装
pip freeze
```

## 批量下载安装WHL包

WHL 其实就是把编译好的 Python 文件打包到了一起，有点类似 Java 的 jar 包，省去了编译过程，可以直接安装。适合在无法联网的机器上快速构建 Python 的依赖环境。

> Python Wheels are the new standard of Python distribution and are intended toreplace eggs.

#### 批量下载

准备好 requirements 文件,里面放需要下载的包名称和版本。例如
```
py4j==0.10.7
pylint==1.9.3
pyspark==2.3.0
```

批量下载
```
pip3.7 download -r requirements.txt -d pip_libs --trusted-host pypi.doubanio.com -i https://pypi.doubanio.com/simple
```

> -d 后面跟的是下载的包存放目录

也可以单独下载某个包
```
pip3.7 download pylint==1.9.3 -d pip_libs --trusted-host pypi.doubanio.com -i https://pypi.doubanio.com/simple
```


#### 批量安装

要使用下载时用到的 requirements.txt：
```
pip install --no-index --find-links=pip_libs -r requirements.txt
```

> -f 或 --find-links 后面跟的是存放whl包的路径。

# pip 使用镜像源

## pip 源

### 源

[pypi.org](https://pypi.org)

- pip官方源: https://pypi.python.org/simple
- 清华：https://pypi.tuna.tsinghua.edu.cn/simple
- 阿里云：http://mirrors.aliyun.com/pypi/simple/
- 华为云：https://repo.huaweicloud.com/repository/pypi/simple
- 中国科技大学 https://pypi.mirrors.ustc.edu.cn/simple/
- 华中理工大学：http://pypi.hustunique.com/
- 山东理工大学：http://pypi.sdutlinux.org/
- 豆瓣：http://pypi.douban.com/simple/
- 加州大学欧文分校: https://www.lfd.uci.edu/~gohlke/pythonlibs/

> 其中豆瓣的源包最全面最完整

### 源设置

阿里云
```
pip3 config set global.index-url http://mirrors.aliyun.com/pypi/simple
pip3 config set install.trusted-host mirrors.aliyun.com
```

华为云
```
[global]
index-url = https://repo.huaweicloud.com/repository/pypi/simple
trusted-host = repo.huaweicloud.com
timeout = 120
```

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
