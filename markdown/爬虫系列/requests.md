# 基础

### requests是什么

Requests 是⽤Python语⾔编写，基于urllib，采⽤Apache2 Licensed开源协议的 HTTP 库。它⽐ urllib 更加⽅便，可以节约我们⼤量的⼯作，完全满⾜HTTP测试需求。 

### 安装requests

```
pip install requests
```

# 访问

```
import requests
request.get('http://httpbin.org/get')
requests.post('http://httpbin.org/post')
requests.put('http://httpbin.org/put')
requests.delete('http://httpbin.org/delete')
requests.head('http://httpbin.org/get')
```

* GET： 请求指定的页面信息，并返回实体主体。

* POST： 请求服务器接受所指定的文档作为对所标识的URI的新的从属实体。

* PUT： 从客户端向服务器传送的数据取代指定的文档的内容。

* DELETE： 请求服务器删除指定的页面。

* HEAD： 只请求页面的首部。

### Get请求

* 基础Get

```
import requests
 
response = requests.get('http://www.baidu.com')
print(response.text)
```

![1598781175764](pic\1598781175764.png)

* 带参数Get

  ```
  import requests
  response = requests.get("http://httpbin.org/get?name=germey&age=22")
  print(response.text)
  ```

  ![1598781365877](pic\1598781365877.png)

### POST请求

* 基础POST

  ```
  import requests
   
  data = {'name': 'germey', 'age': '22'}
  response = requests.post("http://httpbin.org/post", data=data)
  print(response.text)
  ```

  ![1598781540903](pic\1598781540903.png)

* 文件上传

  ```
  import requests
   
  files = {'file': open('cookie.txt', 'rb')}
  response = requests.post("http://httpbin.org/post", files=files)
  print(response.text)
  ```

### 代理访问

```
import requests
 
proxies = {
 "http": "http://127.0.0.1:9743",
 "https": "https://127.0.0.1:9743",
}
 
response = requests.get("https://www.taobao.com", proxies=proxies)
print(response.status_code)
```

### 认证访问

```
import requests
 
from requests.auth import HTTPBasicAuth
 
response = requests.get("http://120.27.34.24:9001/",auth=HTTPBasicAuth("user","123"))
print(response.status_code)
```

# 解析数据

### 解析json

```
import requests
import json
 
response = requests.get("http://httpbin.org/get")
print(type(response.text))
print(response.json())
print(json.loads(response.text))
print(type(response.json()))
```

### 获取二进制数据

```
import requests
 
response = requests.get("https://github.com/favicon.ico")
print(type(response.text), type(response.content))
print(response.text)
#content包含二进制数据
print(response.content)
```

