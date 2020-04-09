class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        #回溯法
        if not p: return not s
        firt_match = bool(s) and p[0] in {s[0],'.'}
        if len(p)>=2 and p[1]=='*':
            return self.isMatch(s,p[2:]) or (firt_match and self.isMatch(s[1:],p))
        else:
            return firt_match and self.isMatch(s[1:],p[1:])
