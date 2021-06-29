# http协议

## Request Headers

```html
POST /signin HTTP/1.1
Host: localhost:5000
Connection: keep-alive
Content-Length: 32
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36
Origin: http://localhost:5000
Content-Type: application/x-www-form-urlencoded
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: http://localhost:5000/signin
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cookie: list_num=0; reload=; live_num=; url_num=2; ....
```

最主要的头两行分析如下，第一行：

```
GET / HTTP/1.1
```

`GET`表示一个读取请求，将从服务器获得网页数据，`/signin`表示URL的路径，URL总是以`/`开头，`/`就表示首页，最后的`HTTP/1.1`指示采用的HTTP协议版本是1.1。目前HTTP协议的版本就是1.1，但是大部分服务器也支持1.0版本，主要区别在于1.1版本允许多个HTTP请求复用一个TCP连接，以加快传输速度。

从第二行开始，每一行都类似于`Xxx: abcdefg`

```
Host: localhost:5000
```

表示请求的域名是`localhost`,端口为5000。如果一台服务器有多个网站，服务器就需要通过`Host`来区分浏览器请求的是哪个网站。



## Response Headers

```
HTTP/1.0 200 OK
Content-Type: text/html; charset=utf-8
Content-Length: 101
Server: Werkzeug/0.14.1 Python/3.6.5
Date: Wed, 02 Jun 2021 16:44:47 GMT
```

HTTP响应分为Header和Body两部分（Body是可选项），我们在`Network`中看到的Header最重要的几行如下：

```
200 OK
```

`200`表示一个成功的响应，后面的`OK`是说明。失败的响应有`404 Not Found`：网页不存在，`500 Internal Server Error`：服务器内部出错，等等。

```
Content-Type: text/html
```

`Content-Type`指示响应的内容，这里是`text/html`表示HTML网页。请注意，浏览器就是依靠`Content-Type`来判断响应的内容是网页还是图片，是视频还是音乐。浏览器并不靠URL来判断响应的内容，所以，即使URL是`http://example.com/abc.jpg`，它也不一定就是图片。

### HTTP请求

跟踪了新浪的首页，我们来总结一下HTTP请求的流程：

步骤1：浏览器首先向服务器发送HTTP请求，请求包括：

方法：`GET`还是`POST`，`GET`仅请求资源，`POST`会附带用户数据；

路径：`/full/url/path`；

域名：由Host头指定：`Host: www.sina.com.cn`

以及其他相关的Header；

如果是POST，那么请求还包括一个Body，包含用户数据。

步骤2：服务器向浏览器返回HTTP响应，响应包括：

响应代码：`200`表示成功，`3xx`表示重定向，`4xx`表示客户端发送的请求有错误，`5xx`表示服务器端处理时发生了错误；

响应类型：由`Content-Type`指定，例如：`Content-Type: text/html;charset=utf-8`表示响应类型是HTML文本，并且编码是`UTF-8`，`Content-Type: image/jpeg`表示响应类型是JPEG格式的图片；

以及其他相关的Header；

通常服务器的HTTP响应会携带内容，也就是有一个Body，包含响应的内容，网页的HTML源码就在Body中。

步骤3：如果浏览器还需要继续向服务器请求其他资源，比如图片，就再次发出HTTP请求，重复步骤1、2。

Web采用的HTTP协议采用了非常简单的请求-响应模式，从而大大简化了开发。当我们编写一个页面时，我们只需要在HTTP响应中把HTML发送出去，不需要考虑如何附带图片、视频等，浏览器如果需要请求图片和视频，它会发送另一个HTTP请求，因此，一个HTTP请求只处理一个资源。

HTTP协议同时具备极强的扩展性，虽然浏览器请求的是`http://www.sina.com.cn/`的首页，但是新浪在HTML中可以链入其他服务器的资源，比如`<img src="http://i1.sinaimg.cn/home/2013/1008/U8455P30DT20131008135420.png">`，从而将请求压力分散到各个服务器上，并且，一个站点可以链接到其他站点，无数个站点互相链接起来，就形成了World Wide Web，简称“三达不溜”（WWW）。

## HTTP格式

每个HTTP请求和响应都遵循相同的格式，一个HTTP包含Header和Body两部分，其中Body是可选的。

HTTP协议是一种文本协议，所以，它的格式也非常简单。HTTP GET请求的格式：

```
GET /path HTTP/1.1
Header1: Value1
Header2: Value2
Header3: Value3
```

每个Header一行一个，换行符是`\r\n`。

HTTP POST请求的格式：

```
POST /path HTTP/1.1
Header1: Value1
Header2: Value2
Header3: Value3

body data goes here...
```

当遇到连续两个`\r\n`时，Header部分结束，后面的数据全部是Body。

HTTP响应的格式：

```
200 OK
Header1: Value1
Header2: Value2
Header3: Value3

body data goes here...
```

HTTP响应如果包含body，也是通过`\r\n\r\n`来分隔的。请再次注意，Body的数据类型由`Content-Type`头来确定，如果是网页，Body就是文本，如果是图片，Body就是图片的二进制数据。

当存在`Content-Encoding`时，Body数据是被压缩的，最常见的压缩方式是gzip，所以，看到`Content-Encoding: gzip`时，需要将Body数据先解压缩，才能得到真正的数据。压缩的目的在于减少Body的大小，加快网络传输。

要详细了解HTTP协议，推荐“[HTTP: The Definitive Guide](http://shop.oreilly.com/product/9781565925090.do)”一书，非常不错，有中文译本：

[HTTP权威指南](http://t.cn/R7FguRq)

