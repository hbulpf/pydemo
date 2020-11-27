# -*- coding=utf-8 -*-

def test01():
    a = int('1' + '1')
    print(a)

def isPalindrome(str):
    i = 0
    while i < (len(str) + 1)/2:
        if(str[i]!=str[-1-i]):
            return False
        i+=1
    return True

print(isPalindrome('AABAA'))
print(isPalindrome('AAEBAA'))