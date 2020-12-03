# -*- coding=utf-8 -*-
# ▪ 输入一个字符串返回满足以下条件的字符串
# ■ 找出与字符串的第一个字母相同的字母，
# 把它们替换成 '*'，除了第一个字母本身以
# 外
# ■ 例如: 输入'babble'， 返回 'ba**le’


def test01(str):
    if len(str) <= 1:
        return str
    s1 = str[0]
    str1 = str[1:]
    str1 = str1.replace(s1, '*')
    return s1 + str1

def test02(str):
    if len(str) <= 1:
        return str
    strlen= len(str)
    s1 = str[0]
    ch_list = list(str[1:])
    for i in range (strlen-1):
        if ch_list[i] == s1:
            ch_list[i] = '*'
    return s1 + ''.join(ch_list)

def test03(str):
    i = 1
    j = len(str)
    s1 = str[0]
    while (i < j):
        if str[i] == s1:
            str = str.replace(str[i], '*')
        else:
            pass
        i += 1
    return str

print(test01('babble'))
print(test02('babble'))
print(test03('babble'))

def test_str_replace():
    str = 'babble'
    # 把一个b都替换成 *
    str = str.replace(str[0], '*')
    print('str:',str)