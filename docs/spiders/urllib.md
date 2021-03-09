# 基础

## Urllib是什么

* python内置的HTTP请求库

## 主要模块 

### request

* HTTP请求模块
* 模拟发送请求

### error

* 异常处理模块
* 捕获请求错误异常
* 保证程序不会意外终止

### parse

* 解析工具模块
* 提供URL处理方法

### robotparser

* 识别网站robots.txt
* 判断网站内被官方允许爬取数据

# 入手教程

## 发送请求

### urlopen

```python
urllib.request.urlopen(url, data=None, [timeout, ]*, cafile=None, capath=None, cadefault=False, context=None)
```

* url表示网站地址

* data

  * data 参数是可选

  * data接受字节流编码格式的内容，即 bytes 类型。

  * 添加data表示请求方式不再是 GET 请求，而是 POST。

  * 代码案例：

    ```kotlin
    import urllib.parse
    import urllib.request
    
    #使用urlencode包装字典，使用bytes函数字节流编码
    data = bytes(urllib.parse.urlencode({'word': 'hello'}), encoding='utf8')
    response = urllib.request.urlopen('http://httpbin.org/post', data=data)
    print(response.read())
    ```

* timeout超时参数

  * timeout 超时时间，单位为秒

  * 如果请求超出设置时间未响应，抛出异常

  * 支持 HTTP、HTTPS、FTP 请求。

  * 注意：需要捕捉异常

  * 代码案例：

    ```
    import socket
    import urllib.request
    import urllib.error
    
    try:
        response = urllib.request.urlopen('http://httpbin.org/get', timeout=0.1)
    except urllib.error.URLError as e:
        if isinstance(e.reason, socket.timeout):
            print('TIME OUT')
    ```

* cafile 和 capath 参数

  * 指定 CA 证书和它的路径
  * 请求 HTTPS 链接时使用

* context 参数

  * 必须是 ssl.SSLContext 类型
  * 用来指定 SSL 设置。

* 

### Request

```kotlin
urllib.request.Request(url, data=None, headers={}, origin_req_host=None, unverifiable=False, method=None)
```

Request抽象封装请求

* url 
  * 请求 URL，必传参数 

* data
  * 功能同urlopen函数中data

* headers
  * headers接受字典类型
  * 等效于Request中header
  *  常用于修改 User-Agent 伪装浏览器 

*  origin_req_host  
  *  指请求方的 host 名称或者 IP 地址 

*  unverifiable  
  *  请求是否是无法验证的， 默认是False 

*  method  
  * 请求使用的方法
  * 可选项： GET，POST，PUT 等

* 代码案例：

  ```
  from urllib import request, parse
  
  url = 'http://httpbin.org/post'
  headers = {
      'User-Agent': 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)',
      'Host': 'httpbin.org'
  }
  dict = {
      'name': 'Germey'
  }
  data = bytes(parse.urlencode(dict), encoding='utf8')
  req = request.Request(url=url, data=data, headers=headers, method='POST')
  response = request.urlopen(req)
  print(response.read().decode('utf-8'))
  ```

## 响应体

### 响应状态码

### 响应头

![1598779923882](pic\1598779923882.png)

## parse解析

### url编辑

* urlencode将字典对象转换成get请求的参数:

  ```
  # coding:utf8
  from urllib.parse import urlencode
  
  params = {
      'name': 'Thanlon',
      'age': 22
  }
  baseUrl = 'http://www.thanlon.cn?'
  url = baseUrl + urlencode(params)
  print(url)
  
  #http://www.thanlon.cn?name=Thanlon&age=22
  ```

* parse.urlparse

  ```
  # coding:utf8
  from urllib.parse import urlparse
  
  result = urlparse('http://www.baidu.com/index.html;user?id=1#comment')
  print(type(result))
  print(result)
  
  <class 'urllib.parse.ParseResult'>
  ParseResult(scheme='http', netloc='www.baidu.com', path='/index.html', params='user', query='id=1', fragment='comment')
  ```

* parse.urlunparse

  ```
  # coding:utf8
  from urllib.parse import urlunparse
  
  data = ['http', 'www.baidu.com', 'index.html', 'user', 'name=Thanlon', 'comment']
  print(urlunparse(data))
  
  #http://www.baidu.com/index.html;user?name=Thanlon#comment
  ```

### Cookie

* cookie的获取(保持登录会话信息)：

```python
# coding:utf8
#cookie的获取(保持登录会话信息)
import urllib.request, http.cookiejar

cookie = http.cookiejar.CookieJar()
handler = urllib.request.HTTPCookieProcessor(cookie)
opener = urllib.request.build_opener(handler)
res = opener.open('http://www.baidu.com')
for item in cookie:
    print(item.name + '=' + item.value)
```

* MozillaCookieJar(filename)形式保存cookie

  ```
  # coding:utf8
  #将cookie保存为cookie.txt
  import http.cookiejar, urllib.request
  
  filename = 'cookie.txt'
  cookie = http.cookiejar.MozillaCookieJar(filename)
  handler = urllib.request.HTTPCookieProcessor(cookie)
  opener = urllib.request.build_opener(handler)
  res = opener.open('http://www.baidu.com')
  cookie.save(ignore_discard=True, ignore_expires=True)
  ```

* LWPCookieJar(filename)形式保存cookie

  ```
  # coding:utf8
  import http.cookiejar, urllib.request
  
  filename = 'cookie.txt'
  cookie = http.cookiejar.LWPCookieJar(filename)
  handler = urllib.request.HTTPCookieProcessor(cookie)
  opener = urllib.request.build_opener(handler)
  res = opener.open('http://www.baidu.com')
  cookie.save(ignore_discard=True, ignore_expires=True)
  ```

* 读取cookie请求，获取登陆后的信息

  ```
  # coding:utf8
  import http.cookiejar, urllib.request
  
  cookie = http.cookiejar.LWPCookieJar()
  cookie.load('cookie.txt', ignore_discard=True, ignore_expires=True)
  handler = urllib.request.HTTPCookieProcessor(cookie)
  opener = urllib.request.build_opener(handler)
  resp = opener.open('http://www.baidu.com')
  print(resp.read().decode('utf-8'))
  ```

## 异常处理

### URLError

* 打开一个不存在的网站

  ```
  from urllib import request, error
  try:
      response = request.urlopen('http://cuiqingcai.com/index.htm')
  except error.URLError as e:
      print(e.reason)
  ```

### HTTPError

* code

  * 返回 HTTP Status Code，即状态码
  * 比如 404 网页不存在，500 服务器内部错误等等。

* reason

  * 同父类一样，返回错误的原因。

* headers

  * 返回 Request Headers。

* 实际运用：

  ```
  from urllib import request, error
  
  try:
      response = request.urlopen('http://cuiqingcai.com/index.htm')
  except error.HTTPError as e:
      print(e.reason, e.code, e.headers, sep='\n')
  except error.URLError as e:
      print(e.reason)
  else:
      print('Request Successfully')
  ```

  