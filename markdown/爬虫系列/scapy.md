# 基础

### Scapy是什么

Scapy是一个Python程序，使用户能够发送，嗅探和剖析并伪造网络数据包。此功能允许构建可以探测，扫描或攻击网络的工具。 

### 安装

* python3 -m pip install scapy

### 使用场景

* 扫描(scanning)
* 路由跟踪(tracerouting)
* 探测(probing)
* 单元测试(unit tests)
* 攻击(attacks)
* 发现网络(network discorvery) 

# 发包收包教程

## 生成数据包

```
# 使用Ether()方法生成一个以太网层数据包
eth_packet = Ether()
# 使用IP()方法生成一个网络层数据包
ip_packet = IP()
# 使用TCP()方法生成一个tcp数据包
tcp_packet = TCP()
# 使用UDP()方法生成一个udp数据包
udp_packet = UDP()
# 使用ICMP()方法生成一个udp数据包
icmp_packet = ICMP()
```

## 查看数据包内容

```
# 使用IP()方法生成一个tcp数据包
ip_packet = IP()

# 方法一、使用raw()方法查看
raw(ip_packet)

# 方法二、使用hexdump()查看。类似Wireshark
hexdump(ip_packet)

# 方法三、raw()配合协议类查看。最佳
# 查看该数据包以太网层内容（下层内容不层示，上层内容不解析只以load形式展示）
Ether(raw(ip_packet))
# 查看该数据包网络层内容（下层内容不层示，上层内容不解析只以load形式展示）
IP(raw(ip_packet))
```

![1597564548443](pic\1597564548443.png)

## 修改内容

### 自定义单层字段

```
# 方法一，在构造时直接传递参数
# 给src传值10.10.6.92，ttl传值128；字段为字符的以字符串形式传，字段为数值的以数值形式传
ip_packet = IP(src="10.10.6.92",ttl=128)
# 查看数据包各项值，确认src项是否为10.10.6.92，ttl项是否为128
IP(raw(ip_packet))
```

```
# 方法二，在生成后重新赋值
# 给src赋值10.10.6.92，ttl赋值128；字段为字符的以字符串形式赋，字段为数值的以数值形式赋
ip_packet.src = "10.10.6.93"
ip_packet.ttl = 200
# 查看数据包各项值，确认src项是否为10.10.6.93，ttl项是否为200
IP(raw(ip_packet))
```

### 自定义多层字段

```
# 构造一个IP数据包，源mac设置为"00:00:00:00:00:11"，源ip设置为"10.10.6.92"
ip_packet = Ether(src="00:00:00:00:00:11")/IP(src="10.10.6.92")
# 当前构造函中最低层为Ether
Ether(raw(ip_packet))
```

```
# 定义一个TCP数据包，源mac设置为"00:00:00:00:00:11"，源ip设置为"10.10.6.92"，源端口设置为1234
tcp_packet = Ether(src="00:00:00:00:00:11")/IP(src="10.10.6.92")/TCP(sport=1234)
# 当前构造函中最低层为Ether
Ether(raw(tcp_packet))
```

```
# 定义一个应用层数据包，应用层内容为"GET / HTTP/1.0\r\n\r\n"
app_packet = IP()/TCP()/"GET / HTTP/1.0\r\n\r\n"
# 当前构造函中最低层为IP
IP(raw(app_packet))
```

## 发送和接收数据

### 发送数据

```python
send(IP(dst="172.0.0.1")/ICMP())

sendp(Ether()/IP(dst="172.0.0.1")/ICMP())
```

### 接收数据

```
rec_packet = sr1(IP(dst="172.0.0.1")/ICMP()/"abcdefg")
rec_packet
# 直接读取某项值
rec_packet.src
# 使用show()方法格式化输出
rec_packet.show()
```

### 发包收包API

- 三层发包和收包：sr(pkt, filter=N, iface=N)
- 二层发包和收包：srp(pkt, filter=N, iface=N) 
- 三层发包但是仅仅接受第一个回复：sr1(pkt, inter=0, loop=0, count=1, iface=N),
- 二层发包但是仅仅接受第一个回复：srp1(pkt, filter=N, iface=N) 
- 在环回口发包并且打印出所有的回复：srloop(pkt, timeout=N, count=N), srploop(…) 

# 抓包教程

## sniff

```
def sniff(count=0, store=1, offline=None, prn=None,filter=None, L2socket=None, timeout=None, opened_socket=None, stop_filter=None, iface=None，*args,**kargs)
```

### 函数参数

- count：抓包的数量，0表示无限制；
- store：保存抓取的数据包或者丢弃，1保存，0丢弃
- offline：从 pcap 文件读取数据包，而不进行嗅探，默认为None
- prn：为每一个数据包定义一个函数，如果返回了什么，则显示。例如：prn = lambda x: x.summary()； （ packct.summar()函数返回的是对包的统计性信息 ）
- filter：过滤规则，使用wireshark里面的过滤语法
- L2socket：使用给定的 L2socket
- timeout：在给定的时间后停止嗅探，默认为 None
- opened_socket：对指定的对象使用 .recv() 进行读取；
- stop_filter：定义一个函数，决定在抓到指定数据包后停止抓包，如：stop_filter = lambda x: x.haslayer(TCP)；
- iface：指定抓包的接口 

### 数据保存

```
package=sniff(iface='eth0',count=10)  #扫描eth0网卡的数据包，总数为10个
wrpcap("test.pcap",package)  #将抓取到的包保存为test.pcap文件
如果我们以后想查看这个包的话，可以这样使用
package = sniff(offline='test.pcap')  或 package= rdpcap('test.pcap')
```

## 过滤抓包

filter 过滤，采用 Berkeley Packet Filter (BPF)语法，与 wireshark 相同过滤语法

### type(定义类型)

可选值：host, net, port, portrange

* host hostnameA
* net 172.31            //相当于172.31.0.0/16,又例如：192.168.1相当于192.168.1.0/24
* port 80
* portrange 6000-6010

### dir(定义传输方向)

可选值：src, dst, src or dst, src and dst

* src net 172.31
* src or dst port 21

### proto(定义网络协议)

可选值：ether, fddi, tr, wlan, ip, ip6, arp, rarp, decnet, tcp, udp, icmp

* ether src hostnameA
* arp net 172.31
* udp portrange 7000-8000

### 关键词

* 连接词：and ,or ,not

*  广播：broadcast

* **less** *length*：报文长度小于等于length，等价于len <= length

* **greater** *length*：报文长度大于等于length，等价于len>= length

* **net** *net* **mask** *netmask*

  *匹配网络号和掩码，掩码格式例如：**255.255.0.0**，**IPv6**不支持此语法*

*  **ether host/src/dst **ehost

  以太网地址/源地址/目的地址为**ehost**，**ehost**可以是名称或number

### 实例

比如：抓取 icmp 的包，按照 源ip-> 目的ip 的格式打印出来 。

```python
sniff(filter="icmp",count=5,prn=lambda x : x.sprintf("{IP:%IP.src%-> %IP.dst%}"))
```

![1597566095766](pic\1597566095766.png)