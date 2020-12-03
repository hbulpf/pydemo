# -*- coding=utf-8 -*-

def test01():
    a = int('1' + '1')
    print(a)


"""
判断是否是回文
"""
def isPalindrome(str):
    i = 0
    while i < (len(str) + 1)/2:
        if(str[i]!=str[-1-i]):
            return False
        i+=1
    return True

"""
最优雅的判断是否回文的方法
"""
def isPalindrome2(str):
    return str == str[::-1]


print(isPalindrome('AABAA'))
print(isPalindrome('AAEBAA'))

print(isPalindrome2('AABAA'))
print(isPalindrome2('AAEBAA'))

