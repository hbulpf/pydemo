class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        index = 0
        j = 0
        t_len = len(t)
        for i in s:
            while j<t_len:
                if i == t[j]:
                    print(i)
                    index = index+1
                    j = j+1
                    break
                else:
                    j = j+1
        print(index)
        if index == len(s):
            return True
        else:
            return False
a = Solution()
b = a.isSubsequence(s="abc",t="ahbgdc")
print(b)