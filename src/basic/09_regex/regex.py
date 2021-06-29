import re


# 请尝试写一个验证Email地址的正则表达式。版本一应该可以验证出类似的Email：
def is_valid_email(addr):
    reg = re.compile(r'^[\w\.]+@(\w+\.)+\w+$')
    ok = reg.match(addr)
    print("addr:%s,%s" % (addr,ok))
    return ok

# 测试:
assert is_valid_email('someone@gmail.com')
assert is_valid_email('bill.gates@microsoft.com')
assert not is_valid_email('bob#example.com')
assert not is_valid_email('mr-bob@example.com')
print('test1 ok')



# 版本二可以提取出带名字的Email地址
def name_of_email(addr):
   return [x for x in re.split(r'[\<\>\@]+', addr) if x][0]


# 测试:
assert name_of_email('<Tom Paris> tom@voyager.org') == 'Tom Paris'
assert name_of_email('tom@voyager.org') == 'tom'
print('test2 ok')
