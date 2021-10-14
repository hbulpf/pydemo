# Web应用中的token

## TimedJSONWebSignatureSerializer

itsdangerous 使用TimedJSONWebSignatureSerializer可以生成带有有效期的token
```python
from itsdangerous import TimedJSONWebSignatureSerializer as Serializer
from itsdangerous import BadData
from django.conf import settings
# serializer = Serializer(秘钥, 有效期秒)
serializer = Serializer(settings.SECRET_KEY, 300)
# serializer.dumps(数据), 返回bytes类型
token = serializer.dumps({'user_id': '123185'})
token = token.decode()


# 检验token
# 验证失败，会抛出itsdangerous.BadData异常
serializer = Serializer(settings.SECRET_KEY, 300)
try:
   data = serializer.loads(token)
except BadData:
   return None
```

生成token

```python
SECRET_KEY = '123456key'
def generate_token(user_id, expiration=3600):
    s = Serializer(SECRET_KEY, expires_in=expiration)
    start_time = int(time.time())
    expire_time = time.strftime("%Y-%m-%d-%H:%M:%S", time.localtime(start_time + expiration))
    token = s.dumps({"id": user_id}).decode("ascii")
    return token, expire_time
```

