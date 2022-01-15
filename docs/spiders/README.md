# 抓包工具

### Fiddler

* 安装地址： https://www.telerik.com/download/fiddler 

* 桌面端抓包
* 手机抓包
  * 下载证书
  * 手机端设置Proxy端口

### wireshark

### scapy

* 安装

  ```
  sudo pip3 install -U scapy-python3
  ```

* 实例

  ```
  from scapy.all import *
  dpkt = sniff(iface = "wlp7s0", count = 100)
  ```

### mitmproxy

# 网页抓取

### urllib

* 安装

  ```
  pip install urllib3
  ```

* 实例

* 

### requests

### scrapy

* scrapy-redis
  * 分布式爬虫框架

# 网页解析

### BeautifulSoup

* 安装

  ```
  sudo pip install -U beautifulsoup4
  ```

* 主要API

* 实例

  ```
  from bs4 import BeautifulSoup
  soup = BeautifulSoup(html, 'lxml')
  print(soup.prettify())
  print(soup.title.string)
  ```

### re

* 正则表达式特殊字符

  ```
  正则表达式
  ^      匹配行首                  
  $      匹配行尾                  
  .      任意单个字符          
  []     匹配包含在中括号中的任意字符
  [^]     匹配包含在中括号中的字符之外的字符
  [-]     匹配指定范围的任意单个字符
  ？     匹配之前项的1次或者0次
  +      匹配之前项的1次或者多次
  *      匹配之前项的0次或者多次
  {n}     匹配之前项的n次
  {m,n}    匹配之前项最大n次，最小m次
  {n,}    配置之前项至少n次
  ```

* 主要方法

  * findall

    * 介绍

      ```
      findall方法，该方法在字符串中查找模式匹配，将所有的匹配字符串以列表的形式返回，如果文本中没有任何字符串匹配模式，则返回一个空的列表，如果有一个子字符串匹配模式，则返回包含一个元素的列表，所以，无论怎么匹配，我们都可以直接遍历findall返回的结果而不会出错，这对工程师编写程序来说，减少了异常情况的处理，代码逻辑更加简洁
      ```

    * 实例

      ```
      # re.findall() 用来输出所有符合模式匹配的子串
        
      re_str = "hello this is python 2.7.13 and python 3.4.5"
        
      pattern = "python [0-9]\.[0-9]\.[0-9]"
      res = re.findall(pattern=pattern,string=re_str)
      print(res)
        
      # ['python 2.7.1', 'python 3.4.5']
        
      pattern = "python [0-9]\.[0-9]\.[0-9]{2,}"
      res = re.findall(pattern=pattern,string=re_str)
      print(res)
        
      # ['python 2.7.13']
      pattern = "python[0-9]\.[0-9]\.[0-9]{2,}"
      res = re.findall(pattern=pattern,string=re_str)
      print(res)
        
      # []
        
      # re.findall() 方法，返回一个列表，如果匹配到的话，列表中的元素为匹配到的子字符串，如果没有匹配到，则返回一个空的列表
        
      re_str = "hello this is python 2.7.13 and Python 3.4.5"
        
      pattern = "python [0-9]\.[0-9]\.[0-9]"
      res = re.findall(pattern=pattern,string=re_str,flags=re.IGNORECASE)
      print(res)
      
      # ['python 2.7.1', 'Python 3.4.5']
        
      # 设置标志flags=re.IGNORECASE，意思为忽略大小写
      ```

  *  **编译的方式使用正则表达式** 

    * 实例

      ```
      # 我们一般采用编译的方式使用python的正则模块，如果在大量的数据量中，编译的方式使用正则性能会提高很多，具体读者们可以可以实际测试
      re_str = "hello this is python 2.7.13 and Python 3.4.5"
      re_obj = re.compile(pattern = "python [0-9]\.[0-9]\.[0-9]",flags=re.IGNORECASE)
      res = re_obj.findall(re_str)
      print(res)
      ```

  * match方法

    * 介绍

      ```
      match方法，类似于字符串中的startwith方法，只是match应用在正则表达式中更加强大，更富有表现力，match函数用以匹配字符串的开始部分，如果模式匹配成功，返回一个SRE_Match类型的对象，如果模式匹配失败，则返回一个None，因此对于普通的前缀匹配，他的用法几乎和startwith一模一样，例如我们要判断data字符串是否以what和是否以数字开头
      ```

    * 实例

      ```
      s_true = "what is a boy"
      s_false = "What is a boy"
      re_obj = re.compile("what")
        
      print(re_obj.match(string=s_true))
      # <_sre.SRE_Match object; span=(0, 4), match='what'
        
      print(re_obj.match(string=s_false))
      # None
        
      s_true = "123what is a boy"
      s_false = "what is a boy"
        
      re_obj = re.compile("\d+")
        
      print(re_obj.match(s_true))
      # <_sre.SRE_Match object; span=(0, 3), match='123'>
        
      print(re_obj.match(s_true).start())
      # 0
      print(re_obj.match(s_true).end())
      # 3
      print(re_obj.match(s_true).string)
      # 123what is a boy
      print(re_obj.match(s_true).group())
      # 123
      print(re_obj.match(s_false))
      # None
      ```

  *  **search方法** 

    ```
    search方法，模式匹配成功后，也会返回一个SRE_Match对象，search方法和match的方法区别在于match只能从头开始匹配，而search可以从字符串的任意位置开始匹配，他们的共同点是，如果匹配成功，返回一个SRE_Match对象，如果匹配失败，返回一个None，这里还要注意，search仅仅查找第一次匹配，也就是说一个字符串中包含多个模式的匹配，也只会返回第一个匹配的结果，如果要返回所有的结果，最简单的方法就是findall方法，也可以使用finditer方法
    ```

  *  **finditer** 

    ```
    #finditer返回一个迭代器，遍历迭代器可以得到一个SRE_Match对象，比如下面的例子
    
    re_str = "what is a different between python 2.7.14 and python 3.5.4"
      
    re_obj = re.compile("\d{1,}\.\d{1,}\.\d{1,}")
      
    for i in re_obj.finditer(re_str):
      print(i)
    # <_sre.SRE_Match object; span=(35, 41), match='2.7.14'>
    # <_sre.SRE_Match object; span=(53, 58), match='3.5.4'>
    ```

    

### XPath

* 介绍

   XPath 是一门在 XML 文档中查找信息的语言。简单来说，html类似于xml结构，但是没有xml格式那么严格

* 教程
  
  * https://www.runoob.com/xpath/xpath-tutorial.html 

# 高速爬虫

### 基本概念

**进程**：进程是一个具有独立功能的程序关于某个数据集合的一次运行活动。进程是操作系统动态执行的基本单元。

**线程**：一个进程中包含若干线程，当然至少有一个线程，线程可以利用进程所拥有的资源。线程是独立运行和独立调度的基本单元。

**协程**：协程是一种用户态的轻量级线程。协程无需线程上下文切换的开销，也无需原子操作锁定及同步的开销。

**同步**：不同程序单元为了完成某个任务，在执行过程中需靠某种通信方式以协调一致，称这些程序单元是同步执行的。

**异步**：为完成某个任务，不同程序单元之间过程中无需通信协调，也能完成任务的方式，不相关的程序单元之间可以是异步的。

**多进程**：多进程就是利用 CPU 的多核优势，在同一时间并行地执行多个任务。多进程模式优点就是稳定性高，因为一个子进程崩溃了，不会影响主进程和其他子进程，但是操作系统能同时运行的进程数是有限的。

**多线程**：多线程模式通常比多进程快一点，但是也快不到哪去，而且，多线程模式致命的缺点就是任何一个线程挂掉都可能直接造成整个进程崩溃，因为所有线程共享进程的内存。

### 协程

* aiohttp

### 多线程

### 多进程

* multiprocessing

# 反爬虫

### 伪装头

* 伪装User-Agent

  User-Agent是指包含浏览器信息、操作系统信息等的一个字符串，也称之为一种特殊的网络协议。服务器通过它判断当前访问对象是浏览器、邮件客户端还是网络爬虫。具体方法可以把User-Agent的值改为浏览器的方式，甚至可以设置一个User-Agent池（list，数组，字典都可以），存放多个“浏览器”，每次爬取的时候随机取一个来设置request的User-Agent，这样User-Agent会一直在变化，防止被墙。

* 常用代理头

  ```
  "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/22.0.1207.1 Safari/537.1",
  "Mozilla/5.0 (X11; CrOS i686 2268.111.0) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.57 Safari/536.11",
  "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3",
  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3",
  "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.0 Safari/536.3",
  "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24",
  "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24",
  ```

### Cookie和sessions

* Cookie池的应用

### 代理IP

* 开源库
  *  https://github.com/jhao104/proxy_pool 

* 公开代理IP库
  *  http://www.goubanjia.com/ 
  *  https://www.xicidaili.com/nn/ 

### 多账号

### 设置时间间隔

* 大规模集中访问对服务器的影响较大，爬虫可以短时间增大服务器负载。这里需要注意的是：设定下载等待时间的范围控制，等待时间过长，不能满足短时间大规模抓取的要求，等待时间过短则很有可能被拒绝访问。设置合理的请求时间间隔，既保证爬虫的抓取效率，又不对对方服务器造成较大影响。

### 验证码

* 滑动验证码
  * b站： https://mp.weixin.qq.com/s?__biz=MzU2ODYzNTkwMg==&mid=2247484321&idx=1&sn=4bc73324acfacda7d3bc82120b19d11a&scene=19#wechat_redirect 
  * CSDN:  https://www.jb51.net/article/188449.htm 
* 图片验证码
  * OCR字符识别
    * 百度API
    * 开源Tesseract-OCR

### JS加密

* execjs

  * 安装

    ```
    pip install PyExecJS
    ```

  * 实例

    ```
    import execjs
    name = execjs.get().name # 获取JS的运行时名称，写代码时可不写
    ctx = execjs.compile("""
           function add(x, y) {
                   return x + y;
              }
    """) # 获取代码编译完成后的对象
     ctx.call("add", 1, 2) # 调用js函数add，并传入它的参数
     ctx.eval("add({0}, {1})").format(1,2) # 使用eval的写法同上，但是在传入字符串或者其他类型的数据时需要添加对应的格式,如下所示，具体可在程序中debug
     ctx.eval('add("{0}", "{1}")').format("1","2")
    ```

* 禁用debug

### CSS字体加密

* 大众点评：https://www.cnblogs.com/tuchuss/p/13045424.html 
* 汽车之家： https://zhuanlan.zhihu.com/p/82582684 

### 浏览器模拟

* selenium

  * 介绍

    selenium 是一个用于Web应用程序测试的工具。Selenium测试直接运行在浏览器中，就像真正的用户在操作一样。支持的浏览器包括IE（7, 8, 9, 10, 11），Mozilla Firefox，Safari，Google Chrome，Opera等。selenium 是一套完整的web应用程序测试系统，包含了测试的录制（selenium IDE）,编写及运行（Selenium Remote Control）和测试的并行处理（Selenium Grid）。

  * 安装

    ```
    sudo pip install -U selenium
    ```

  * 实例

    ```
    from selenium import webdriver
    driver = webdriver.Firefox()
    driver.get(‘https://www.hao123.com‘)
    html=driver.page_source.encode(‘utf-8’,’ignore’) #这个函数获取页面的html
    print(html)
    driver.close()
    ```

* PhantomJS 

  * 介绍

    PhantomJS 称为无头浏览器，一个而基于WebKit的服务端JavaScript API,支持Web而不需要浏览器支持，其快速、原生支持各种Web标准：Dom处理，CSS选择器，JSON等等。PhantomJS可以用用于页面自动化、网络监测、网页截屏，以及无界面测试

  * 相关网址

    PhantomJS官方地址：[http://phantomjs.org/](https://links.jianshu.com/go?to=http%3A%2F%2Fphantomjs.org%2F)。
    PhantomJS官方API：[http://phantomjs.org/api/](https://links.jianshu.com/go?to=http%3A%2F%2Fphantomjs.org%2Fapi%2F)。
    PhantomJS官方示例：[http://phantomjs.org/examples/](https://links.jianshu.com/go?to=http%3A%2F%2Fphantomjs.org%2Fexamples%2F)。
    PhantomJS GitHub：https://github.com/ariya/phantomjs/

* Appium

### 模拟登录

* 案例
  * https://github.com/xchaoinfo/fuck-login 