# 启动Jupyterhub 服务
1. 下载安装[anaconda](https://repo.anaconda.com/archive/)，并生效环境变量
    如果已经安装了anaconda，执行生效环境变量并激活py36环境：
    ```
    export PATH="/opt/anaconda3/bin:$PATH"
    source activate py36 # 激活py36
    ```

2. JupyterHub
    ```
    conda install -c conda-forge jupyterhub notebook
    ```

3. 创建配置文件
    ```
    jupyterhub --generate-config
    ```

4. 修改配置文件:根据实际情况修改jupyterhub_config.py的配置
    ```
    c.JupyterHub.ip = '0.0.0.0' #IP地址
    c.JupyterHub.port = 8010  #JupyterHub端口
    c.PAMAuthenticator.encoding = 'utf8'  #编码
    ```

    其他配置

    ```
    c.LocalAuthenticator.create_system_users = True
    c.Authenticator.whitelist = {'user1', 'user1', 'user3'}
    c.Authenticator.admin_users = {'lipengfei', 'lipengcheng', 'lijiawei','pangxiognwen'}
    c.LocalAuthenticator.group_whitelist = {'group1'}
    c.JupyterHub.statsd_prefix = 'jupyterhub'
    ```

5. 启动JupyterHub
    ```
    nohup jupyterhub --no-ssl > jupyterhub.log &
    ```

# 参考
1. http://www.mamicode.com/info-detail-2309029.html
2. https://github.com/jupyterhub/jupyterhub