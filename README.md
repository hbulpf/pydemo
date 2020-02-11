# python 案例与文档

```
├─docs
│  ├─anaconda
│  ├─jupyter
│  ├─ml
│  │  ├─autokeras
│  │  ├─keras
│  │  ├─nvidia_cuda
│  │  ├─pytorch
│  │  ├─recommendation_sys
│  │  │  └─music_recommendation
│  │  └─tesorflow
│  └─python
├─script
│  ├─js
│  └─shell
└─src
    ├─basic
    ├─music_recommendation
    ├─seleniumdemo
    └─surprisedemo
```

## [文档](./docs/README.md)
### python 
1. python 基本
    - [pip使用镜像](python/pip_mirrors.md)
1. [pycharm](pycharm.md)


### AI

#### 基本环境
1. Anaconda
    - [安装 Anaconda](anaconda/install_anaconda.md)
    - [conda基本命令](anaconda/conda_cmd.md)
    - [anaconda 生成py36环境](anaconda/py37_To_py36.md)
    
1. Jupyter Notebook
    - [Jupyter](./jupyter/jupyter_service.md)
    - [Jupyterhub](jupyter/jupyterhub_service.md)

#### ai 环境
1. [安装NVIDIA-Linux-x86_64-384.145,cuda-9.0, libcudnn7-7.5.0.56-1](ml/nvidia_cuda/)
1. [安装Tensorflow 1.13.1](ml/tesorflow/tesorflow.md)
1. [安装Pytorch 1.1.0](ml/pytorch/pytorch.md)
1. [安装Keras 2.2.4](ml/keras/keras.md)
1. [安装AutoKeras 0.4.0](ml/autokeras/autokeras.md)

#### 推荐系统
1. [音乐推荐系统](./ml/recommendation_sys/music_recommendation/)

## [源码](./src/)

- [基础练习](./src/basic/)
- [音乐推荐](./src/music_recommendation)
- [selenium](./src/seleniumdemo)
- [sci-surprise](./src/surprisedemo)

## [脚本](./script/)

- [javascript 脚本](./script/js)
- [shell 脚本](./script/shell)