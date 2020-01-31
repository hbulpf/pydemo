# conda 常见命令

> 查看，创建，激活，关闭，更新，卸载，删除，清理

## 0. 获取版本号
```bash
conda --version
```
或
```bash
conda -V
```

## 1. 获取帮助
```
conda --help
conda -h
```

查看某一命令的帮助，如update命令及remove命令
```
conda update --help
conda remove --help
```

同理，以上命令中的--help也可以换成-h。

## 2. 环境管理


查看环境管理的全部命令帮助
```
conda env -h
```

#### 查看虚拟环境
```bash
conda-env list  #查看虚拟环境
conda env list  #显示所有的虚拟环境
conda info --envs
```

#### 创建虚拟环境

```
conda create --name your_env_name 
#或
conda create -n your_env_name 
```

创建特定python版本的环境，如建立python3.6的虚拟环境，并将虚拟环境命名为py36
```bash
conda create -n py36 python=3.6 #建立python3.6的虚拟环境，并将虚拟环境命名为py36
```

创建指定python版本下包含某些包的环境
```bash
conda create --name your_env_name python=3.5 numpy scipy
```

#### 激活虚拟环境
激活python3.6版本的虚拟环境
```bash
source activate py36 #激活python3.6版本
```

#### 退出虚拟环境
退出py36虚拟环境
```
source deactivate
```

#### 卸载虚拟环境
```bash
conda remove -n xxxx --all #卸载xxxx虚拟环境
```

#### 复制环境
```
conda create --name new_env_name --clone old_env_name 
```

conda环境以上命令可以换成如下命令
```bash
conda update -n base conda        //更新base环境最新版本的conda
conda create -n xxxx python=3.5   //创建python3.5的xxxx虚拟环境
conda activate xxxx               //开启xxxx环境
conda deactivate                  //关闭环境
conda env list                    //显示所有的虚拟环境
conda remove -n xxxx --all //删除xxxx虚拟环境
```


## 3. 分享环境



## 4. 软件包管理

查看环境下已有的安装包
```bash
conda list
```

安装xxx安装包
```
conda install xxx   #安装xxx安装包
```

更新/卸载xxx安装包
```bash
conda update xxx   #更新xxx安装包
conda uninstall xxx   #卸载xxx安装包
```


清理无用包（conda瘦身）

第一步: 通过 `conda clean -p` 删除一些没用的包，会检查哪些包没有在包缓存中被硬依赖到其他地方，并删除它们。
第二步: 通过 `conda clean -t` 删除缓存的tar软件包
```
conda clean -p      //删除没有用的包
conda clean -t      //tar打包
```

## conda 升级

更新所有库
```bash
conda update --all
```


升级自身
```bash
conda update conda   # 更新 conda 自身
conda update anaconda  # 更新 anaconda
conda update anaconda-navigator    #update最新版本的anaconda-navigator   
```

## conda Channels
添加 Channels 可以加快包的下载速度

### Channels 源

##### 官方Channels
```bash
conda config --add channels bioconda
conda config --add channels conda-forge
```

##### 清华大学 Channels

```bash
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/free/
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/main/
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/cloud/conda-forge/
conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/cloud/bioconda/
```

##### 其他Channels
```
conda config --add channels genomedk
```

### 使用 Channels

使用特定频道下载指定版本的软件包
```bash
conda install --channel https://conda.anaconda.org/conda-forge scikit-surprise=1.1.0
```

## anaconda特定版本软件包
> 以 TensorFlow 1.8.0 为例

1. 打开anaconda-prompt
2. 查看tensorflow各个版本：`anaconda search -t conda tensorflow`（查看会发现有一大堆TensorFlow源，但是不能随便选，选择可以用查找命令定位）

3. 找到自己安装环境对应的最新TensorFlow, 查看指定包: `anaconda show <USER/PACKAGE>`
   
   查看tensorflow版本信息: `anaconda show anaconda/tensorflow`

4. 查找后确定要安装1.8.0版本tensorflow, 从指定源安装
```
conda install --channel https://conda.anaconda.org/anaconda tensorflow=1.8.0 
```



# 参考
1. [Conda常用命令整理](https://blog.csdn.net/menc15/article/details/71477949)
2. [conda的安装与使用](https://www.jianshu.com/p/edaa744ea47d)