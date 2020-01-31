# 搭建环境

##  <font color=red> 配置基本环境 </font>

1. 安装 Anaconda，并配置环境变量, [安装 Anaconda](../../../anaconda/install_anaconda.md) 
2. 更换 Anaconda 的镜像源，命令行输入：
    ```bash
    conda config --add channels https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/free/
    conda config --set show_channel_urls yes
    ```
3. 删除目录 `C:\Users\\<你的用户名>` 下配置文件.condarc中的 `-default` 
4. 安装 Surprise 库，命令行输入：`conda install scikit-surprise`
5. 升级 pip，命令行输入： `python -m pip install --upgrade pip`
6. 安装 gensim 库，命令行输入：`pip install gensim`
7. 安装tensorflow 库，命令行输入：`pip install tensorflow==1.4.0`
8. 安装 pyspark 库，命令行输入：`pip install pyspark`
9. 安装 JDK, 下载 JDK 并解压 ：http://47.93.208.249:9925/tree/0.Teacher/Online/software
10. 安装 Hadoop, 下载 Hadoop 并解压：http://47.93.208.249:9925/tree/0.Teacher/Online/software
11. 安装 Spark, 下载 Spark 并解压：http://47.93.208.249:9925/tree/0.Teacher/Online/software

## JDK、Hadoop、Spark 解压后需要配置环境变量

1. windows上环境变量设置：右键我的电脑==》属性==》高级系统设置==》环境变量==》系统变量
2. 配置 jdk 环境变量
    - 新建系统变量JAVA_HOME,设置值为"JDK解压路径"
    - 编辑系统变量PATH，添加 %JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;
3. 配置 hadoop 环境变量
    - 新建系统变量HADOOP_HOME,设置值="hadoop解压路径"
    - 编辑系统变量PATH，添加 %HADOOP_HOME%\bin;
4. 配置 spark 环境变量：
    - 新建系统变量SPARK_HOME,设置值为"spark解压路径"
    - 编辑系统变量PATH，添加 %SPARK_HOME%\bin;
5. 验证安装，命令行输入如下命令，若可以显示出对应版本信息，则说明安装成功
    - java -version
    - hadoop version
    - pyspark --version