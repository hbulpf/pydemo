# -*- coding=utf-8 -*-

def test04(str):
    if len(str) <= 1:
        return str
    strlen= len(str)
    s1 = str[0]
    ch_list = [ch for ch in str[1:] if ch !=s1]
    return s1 + ''.join(ch_list)

print(test04('babble'))