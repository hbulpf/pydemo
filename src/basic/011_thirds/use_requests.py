import requests

r = requests.get('https://www.baidu.com/')
print(f'status_code:{r.status_code}')
print(f'text:{r.text}')

r = requests.get('https://www.baidu.com/', params={'wd': 'python'})
print(f'url:{r.url}')
print(f'status_code:{r.status_code}')
print(f'text:{r.text}')
print(f'encoding:{r.encoding}')