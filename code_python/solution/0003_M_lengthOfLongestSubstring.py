#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
3. 无重复字符的最长子串

@Time : 2022/1/14 23:22
@Author: RunAtWorld
@File: 0003_M_lengthOfLongestSubstring.py
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        O(N) = n

        """
        dup_dic = dict()
        s_len = len(s)
        # ans是结果; k是匹配串的起始位置,
        ans, k = 0, -1
        for i, c in enumerate(s):
            # 字符c在字典中 且 上次出现的下标大于当前长度的起始下标
            if c in dup_dic and dup_dic[c] > k:
                k = dup_dic[c]
                dup_dic[c] = i
            else:
                dup_dic[c] = i
                ans = max(ans, i - k)
        return ans

    def lengthOfLongestSubstring3(self, s: str) -> int:
        """
        O(N) = n*n
        为减少字符串的枚举个数，可以利用p1 - p2 指针之间的不重复的这部分字符串
        """
        occ = set()
        s_len = len(s)
        r_p, ans = 0, 0
        for i in range(s_len):
            if i > 0:
                # 第1个字符放过去
                occ.remove(s[i - 1])
            while r_p < s_len and s[r_p] not in occ:
                # 右指针向右滑动
                occ.add(s[r_p])
                r_p += 1
            ans = max(ans, len(occ))
        return ans

    def lengthOfLongestSubstring2(self, s: str) -> int:
        """
        O(N) = n*n
        相当于枚举所有字符串。每次都会从p1指针开始，形成一个全新的字符串。
        不足: 没有利用 p1 - p2 指针之间的不重复的这部分字符串
        """
        s_len = len(s)
        if not s:
            return 0
        max_len = 1
        seq_set = set()
        for p1 in range(s_len):
            seq_set.clear()
            seq_set.add(s[p1])
            for p2 in range(p1 + 1, s_len):
                if s[p2] in seq_set:
                    break
                seq_set.add(s[p2])
            max_len = max(max_len, len(seq_set))
        return max_len


if __name__ == '__main__':
    s = "abcabcbb"
    solution = Solution()
    print(solution.lengthOfLongestSubstring(s))  # 3

    s = " "
    solution = Solution()
    print(solution.lengthOfLongestSubstring(s))  # 1

    s = "au"
    solution = Solution()
    print(solution.lengthOfLongestSubstring(s))  # 2
