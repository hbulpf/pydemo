# 基础

## Scrapy框架

* Scrapy是爬取网站数据，提取结构性数据编写的应用框架

* 使用Twisted异步网络框架处理网络通讯。

## 架构图

 ![图片描述](pic\bVco7P) 

### Scrapy Engine(引擎)

负责Spider、ItemPipeline、Downloader、Scheduler中间的通讯，信号、数据传递等。

### Scheduler(调度器)

* 接受引擎发送过来的Request请求
* 按照一定的方式进行整理排列，入队
* 当引擎需要时，交还给引擎。

### Downloader（下载器）

* 负责下载Scrapy Engine(引擎)发送的所有Requests请求
* 并将其获取到的Responses交还给Scrapy Engine(引擎)
* 再由引擎交给Spider来处理

### Spider（爬虫）

* 负责处理所有Responses,分析提取数据
* 获取Item需要的数据，并将下一个URL提交给引擎
* 再次进入Scheduler(调度器)

### Item Pipeline(管道)

* 负责处理Spider中获取到的Item
* 行进行后期处理（详细分析、过滤、存储等）

### Downloader Middlewares（下载中间件）

* 自定义扩展下载功能的组件

### Spider Middlewares（Spider中间件）

* 可以自定扩展和操作引擎
* Spider中间通信的功能组件

## 执行流程

* spider的yeild将request发送给engine

* engine对request不做任何处理发送给scheduler
* scheduler，生成request交给engine
* engine拿到request，通过middleware发送给downloader
* downloader在获取到response之后，又经过middleware发送给engine
* engine获取到response之后，返回给spider，spider的parse()方法对获取到的response进行处理，解析出items或者requests
* 将解析出来的items或者requests发送给engine
* engine获取到items或者requests，将items发送给ItemPipeline，将requests发送给scheduler

### 官方地址

Scrapy框架官方网址：http://doc.scrapy.org/en/latest

Scrapy中文维护站点：[http://scrapy-chs.readthedocs...](http://scrapy-chs.readthedocs.io/zh_CN/latest/index.html)

### 安装方式

```
 pip install Scrapy 
```

# 入门教程

## 目标

- 创建一个Scrapy项目
- 定义提取的结构化数据(Item)
- 编写爬取网站的 Spider 并提取出结构化数据(Item)
- 编写 Item Pipelines 来存储提取到的Item(即结构化数据)

## 创建项目

```
scrapy startproject mySpider
```

mySpider 为项目名称

### 主要文件：

* scrapy.cfg ：项目的配置文件

* mySpider/ ：项目的Python模块，将会从这里引用代码

* mySpider/items.py ：项目的目标文件

* mySpider/pipelines.py ：项目的管道文件

* mySpider/settings.py ：项目的设置文件

* mySpider/spiders/ ：存储爬虫代码目录

## 明确数据结构

###  items.py

* 定义ORM映射关系
* Item 定义结构化数据字段，用来保存爬取到的数据。
* 可以通过创建一个 scrapy.Item 类， 并且定义类型为scrapy.Field的类属性来定义一个Item

```
class Web163Item(scrapy.Item):
    title = scrapy.Field()
    url = scrapy.Field()
    images_urls = scrapy.Field()
    images = scrapy.Field()
    image_paths = scrapy.Field()
```

## 编写Spider

```
# -*- coding: utf-8 -*-
import scrapy
import sys
from tutorial.items import Web163Item

reload(sys)
sys.setdefaultencoding('utf-8')

class MySpider(scrapy.Spider):
    name = '163'
    allowed_domains = ['163.com']
    start_urls = [
        'http://open.163.com/'
    ]
def parse(self, response):
    item = Web163Item()
    sel = scrapy.Selector(response)
    p_list = sel.xpath('//div[@class="mainslideData"]//p')
    print "-------------info-------------\n"
    i = 1
    for p_info in p_list:
        print "---------------" + str(i) + "-----------------"
        span_list = p_info.xpath('.//span').extract()
        image_url = span_list[1]
       url = span_list[0]
       item['title'] = title
       item['url'] = url
        item['images_urls'] = image_url
        print "title:" + title
        print "html url:" + url
        print "image url:" + image_url
        i = i + 1
        yield item #yield迭代器，需要每次读取数据时进行yield一下，如果不yield则pipeline接收不到数据process_item不能被调用
     print "-----------------\n"
     # yield item
```

## 编写pipline

```
import json
import sys

reload(sys)
sys.setdefaultencoding('utf-8')

class TutorialPipeline(object):
    def process_item(self, item, spider):
        print "pipeline1"
        return item

class JsonWriterPipeline(object):

    def __init__(self):
        self.file = open('items.jl', 'wb')

    def process_item(self,item,spider):
        line = json.dumps(dict(item), ensure_ascii=False) + '\n'   #dump加参数解决中文乱码问题
        self.file.write(line.decode('utf-8','ignore'))
        return item

    def open_spider(self,spider):
        print("scrapy start")

    def close_spider(self,spider):
        print("scrapy end")
        self.file.close()

class MyImagesPipeline(ImagesPipeline):

    def get_media_requests(self, item, info):
        image_url = item['images_urls']
        yield Request(image_url)

    def file_path(self, request, response=None, info=None):
        open("image_urls.txt","a").write(request.url + "\n")
        image_guid = request.url.split('/')[-1]
        return 'full/%s' % (image_guid)

    def item_completed(self, results, item, info):
        image_paths = [x['path'] for ok, x in results if ok]
        if not image_paths:
            raise DropItem("Item contains no images")
        print 'image_paths bellow:'
        for image_path in image_paths:
            print image_path
        item['image_paths'] = image_paths
        return item
```

## 配置settings.py

```
ITEM_PIPELINES = {
   'tutorial.pipelines.TutorialPipeline': 300,
    'tutorial.pipelines.JsonWriterPipeline': 500,
     'tutorial.pipelines.MyImagesPipeline': 550
}

IMAGES_STORE = '../pic'
IMAGES_EXPIRES = 90  
```

## 执行run

```
scrapy crawl 163
现在希望通过程序执行的方式启动爬虫，run.py文件的内容如下：
from twisted.internet import reactor
from scrapy.crawler import CrawlerRunner
from scrapy.utils.project import get_project_settings
import sys

reload(sys)
sys.setdefaultencoding('utf-8')

runner = CrawlerRunner(get_project_settings()) #读取settings.py的内容

d = runner.crawl('163', domain='163.com')
d.addBoth(lambda _: reactor.stop())
reactor.run()
```

# Spider-redis

## 框架

 ![这里写图片描述](pic\70) 

## 分布式策略：

假设有四台电脑：Windows 10、Mac OS X、Ubuntu 16.04、CentOS 7.2，任意一台电脑都可以作为 Master端 或 Slaver端，比如：

- `Master端`(核心服务器) ：使用 Windows 10，搭建一个Redis数据库，不负责爬取，只负责**url指纹判重、Request的分配，以及数据的存储**
- `Slaver端`(爬虫程序执行端) ：使用 Mac OS X 、Ubuntu 16.04、CentOS 7.2，负责执行爬虫程序，运行过程中提交新的Request给Master

![这里写图片描述](pic\72)

1. 首先Slaver端从Master端拿任务（Request、url）进行数据抓取，Slaver抓取数据的同时，产生新任务的Request便提交给 Master 处理；
2. Master端只有一个Redis数据库，负责将未处理的Request去重和任务分配，将处理后的Request加入待爬队列，并且存储爬取的数据。

Scrapy-Redis默认使用的就是这种策略，我们实现起来很简单，因为任务调度等工作Scrapy-Redis都已经帮我们做好了，我们只需要继承RedisSpider、指定redis_key就行了。

* 缺点:Scrapy-Redis调度的任务是Request对象，里面信息量比较大（不仅包含url，还有callback函数、headers等信息），可能导致的结果就是会降低爬虫速度、而且会占用Redis大量的存储空间，所以如果要保证效率，那么就需要一定硬件水平

##  安装

### 安装redis

### 安装spider-redis