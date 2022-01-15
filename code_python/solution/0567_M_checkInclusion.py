#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
567. 字符串的排列

@Time : 2022/1/15 22:44
@Author: RunAtWorld
@File: 0567_M_checkInclusion.py
"""


class Solution:
    def checkInclusion1(self, s1: str, s2: str) -> bool:
        """
        O(n) = n * m
        滑动窗口法，依次检测s2中 len(s1) 长度的子串是否和 s1等价
        """
        s1_len = len(s1)
        s2_len = len(s2)
        if s2_len < s1_len:
            return False
        for i in range(s2_len - s1_len + 2):
            r = i + s1_len - 1
            if self.is_equal(s1, s2[i: r + 1]):
                return True
        return False

    def is_equal(self, s1, s2) -> bool:
        """
        判断 s1 和 s1 是否等价，即两者是否含有相同的字符
        """
        if len(s1) != len(s2):
            return False
        s1_dict = dict()
        for c in s1:
            if c in s1_dict:
                s1_dict[c] +=1
            else:
                s1_dict[c] = 1
        for c in s2:
            if c in s1_dict and s1_dict[c] > 0:
                s1_dict[c] -= 1
            else:
                return False
        return True

    def test_is_equal(self):
        print(self.is_equal("acsb", "adsc"))
        print(self.is_equal("acsb", "absc"))


if __name__ == '__main__':
    solution = Solution()
    s1 = "ab"
    s2 = "eidbaooo"
    print(solution.checkInclusion(s1, s2))

    s1= "ab"
    s2 = "eidboaoo"
    print(solution.checkInclusion(s1, s2))

    s1= "abdcexe"
    s2 = "cedxaeb"
    print(solution.checkInclusion(s1, s2))