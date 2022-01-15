# Anaconda

### 1. 下载 Anaconda 

```shell
sudo wget  https://repo.anaconda.com/archive/Anaconda2-5.3.1-Linux-x86_64.sh #下载anaconda 2.7
# sudo wget  https://repo.anaconda.com/archive/Anaconda3-5.3.1-Linux-x86_64.sh #下载anaconda 3.7
# sudo wget https://mirrors.tuna.tsinghua.edu.cn/anaconda/archive/Anaconda3-5.3.1-Linux-x86_64.sh #使用清华大学源下载anaconda 3.7
```

如果下载比较慢，可以使用

1. [清华大学镜像源](https://mirrors.tuna.tsinghua.edu.cn/anaconda/archive/)
2. [anaconda历史版本镜像源](https://repo.continuum.io/archive/)

### 2. 使用

安装

```shell
sh Anaconda3-5.3.1-Linux-x86_64.sh
```

要建一个python3.5的虚拟环境（其中myenv是这个环境的名称，可以自定）：

```
conda create -n py35 python=3.5
```

然后用以下命令进入该虚拟环境即可：

```
activate py35
```

## 3. Python与Anaconda版本配套

参考 [python与anaconda配套](python与anaconda配套.md)

## 参考

1. [anaconda python 版本对应关系](https://blog.csdn.net/yuejisuo1948/article/details/81043823)
2. [Anaconda Python 版本对应关系表](https://blog.csdn.net/zzqhello2018/article/details/90896852)