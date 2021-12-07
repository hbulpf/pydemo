class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()
        i = 0
        j = 0
        g_len = len(g)
        s_len = len(s)
        res = 0
        while i<g_len and j<s_len:
            if g[i]<=s[j]:
                i = i+1
                j = j+1
                res = res + 1
            else:
                j = j+1
        return res