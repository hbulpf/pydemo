import base64

print(base64.b64encode(b'binary\x00string'))
print(base64.b64decode(b'YmluYXJ5AHN0cmluZw=='))

print(base64.b64encode(b'i\xb7\x1d\xfb\xef\xff'))
print(base64.urlsafe_b64encode(b'i\xb7\x1d\xfb\xef\xff'))
print(base64.urlsafe_b64decode('abcd--__'))

def safe_base64_decode(s):
    s = s + '=' * ((4 - len(s)%4) % 4)
    print(f's:{s}')
    return base64.b64decode(s)
    
# 测试:
assert b'abcd' == safe_base64_decode('YWJjZA=='), "safe_base64_decode('YWJjZA==')"
assert b'abcd' == safe_base64_decode('YWJjZA'), "safe_base64_decode('YWJjZA')"
assert b'abcd' == safe_base64_decode('YWJjZA='), "safe_base64_decode('YWJjZA')"
print('ok')