from urllib import request
import json

# 利用urllib读取JSON，然后将JSON解析为Python对象：
def fetch_data(url):
    req = request.Request(url)
    with request.urlopen(req) as f:
        rsp = f.read()
        print('Status:',f.status,f.reason)
        for k,v in f.getheaders():
            print('%s: %s' % (k,v))
        print("rsp:",rsp.decode('utf-8'))
        return json.loads(rsp.decode('utf-8'))
        


# 测试
URL = 'http://www.httpbin.org/get'
data = fetch_data(URL)
print(data)
assert data['headers']['Host'] == 'www.httpbin.org'
print('ok')