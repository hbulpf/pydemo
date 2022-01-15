# -*- coding: utf-8 -*-
import hashlib
import random

md5 = hashlib.md5()
md5.update('how to use md5 in python hashlib?'.encode('utf-8'))
print(md5.hexdigest())


sha1 = hashlib.sha1()
sha1.update('how to use sha1 in '.encode('utf-8'))
sha1.update('python hashlib?'.encode('utf-8'))
print(sha1.hexdigest())


# 设计一个验证用户登录的函数，根据用户输入的口令是否正确，返回True或False
db = {
    'michael': 'e10adc3949ba59abbe56e057f20f883e',
    'bob': '878ef96e86145580c38c87f0410ad153',
    'alice': '99b1c2188db85afee403b1536010c2c9'
}


def calc_md5(password):
    md5 = hashlib.md5()
    md5.update(password.encode('utf-8'))
    print("md5:", md5.hexdigest())
    return md5.hexdigest()


def calc_sha1(password):
    sha1 = hashlib.sha1()
    sha1.update(password.encode('utf-8'))
    print("sha1:", sha1.hexdigest())
    return sha1.hexdigest()


def login(user, password):
    return db.get(user) == calc_md5(password)


# 测试:
assert login('michael', '123456')
assert login('bob', 'abc999')
assert login('alice', 'alice2008')
assert not login('michael', '1234567')
assert not login('bob', '123456')
assert not login('alice', 'Alice2008')
print('ok')
