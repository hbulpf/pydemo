#/bin/bash
jupyterhub --generate-config #生成并激活配置文件


#消除配置文件的注释
sed -i 's/^#\([ ]*c.JupyterHub.ip\)/\1/' jupyterhub_config.py
sed -i 's/^#\([ ]*c.JupyterHub.port\)/\1/' jupyterhub_config.py
sed -i 's/^#\([ ]*c.Authenticator.whitelist\)/\1/' jupyterhub_config.py
sed -i 's/^#\([ ]*c.Authenticator.admin_users\)/\1/' jupyterhub_config.py
sed -i 's/^#\([ ]*c.JupyterHub.statsd_prefix\)/\1/' jupyterhub_config.py

#修改启动参数配置
sudo sed -i 's/^[ ]*c.JupyterHub.ip.*/c.JupyterHub.ip = "0.0.0.0"/g' jupyterhub_config.py
sudo sed -i 's/^[ ]*c.JupyterHub.port.*/c.JupyterHub.port = 8010/g' jupyterhub_config.py
sudo sed -i 's/^[ ]*c.PAMAuthenticator.encoding.*/c.PAMAuthenticator.encoding = "utf8"/g' jupyterhub_config.py
sudo sed -i 's/^[ ]*c.LocalAuthenticator.create_system_users.*/c.LocalAuthenticator.create_system_users = True/g' jupyterhub_config.py
sudo sed -i 's/^[ ]*c.Authenticator.whitelist.*/c.Authenticator.whitelist = {"root", "lpf", "yx"}/g' jupyterhub_config.py
sudo sed -i 's/^[ ]*c.Authenticator.admin_users.*/c.Authenticator.admin_users = {"root", "lpf"}/g' jupyterhub_config.py
sudo sed -i 's/^[ ]*c.JupyterHub.statsd_prefix.*/c.JupyterHub.statsd_prefix = "jupyterhub"/g' jupyterhub_config.py


nohup jupyterhub --no-ssl >jupyterhub.log 2>&1  &

