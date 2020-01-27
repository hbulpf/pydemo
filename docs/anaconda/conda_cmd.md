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

conda --help
conda -h

查看某一命令的帮助，如update命令及remove命令

conda update --help
conda remove --help

同理，以上命令中的--help也可以换成-h。

## 2. 环境管理

查看虚拟环境
```bash
conda-env list  # 查看虚拟环境
conda env list  #显示所有的虚拟环境
```

建立python3.6的虚拟环境，并将虚拟环境命名为py36
```bash
conda create -n py36 python=3.6 #建立python3.6的虚拟环境，并将虚拟环境命名为py36
```

激活python3.6版本的虚拟环境
```bash
source activate py36 #激活python3.6版本
```


退出py36虚拟环境，使用命令：
```
source deactivate
```

卸载xxxx虚拟环境
```bash
conda remove -n xxxx --all #卸载xxxx虚拟环境
```

conda环境以上命令可以换成如下命令
```bash
conda update -n base conda        //update最新版本的conda
conda create -n xxxx python=3.5   //创建python3.5的xxxx虚拟环境
conda activate xxxx               //开启xxxx环境
conda deactivate                  //关闭环境
conda env list                    //显示所有的虚拟环境
conda remove -n xxxx --all //创建xxxx虚拟环境
```


## 软件包管理

查看环境下已有的安装包
```bash
conda list
```

更新/卸载xxx安装包
```bash
conda update xxx   #更新xxx安装包
conda uninstall xxx   #卸载xxx安装包
```


## conda 升级

```bash
conda update conda
conda update anaconda
conda update anaconda-navigator    //update最新版本的anaconda-navigator   
```


# 参考
1. [Conda常用命令整理](https://blog.csdn.net/menc15/article/details/71477949)