class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack_s = []
        index = -1
        for i in s:
            if i =="(" or i == "[" or i == "{":
                stack_s.append(i)
                index = index + 1
                continue
            if i == ")" and len(stack_s) > 0:
                if stack_s[index] == "(":
                    del stack_s[index]
                    index = index -1
                    continue
                else: return False
            elif i == ")" and len(stack_s) ==0:
                return False

            if i == "]" and len(stack_s) > 0:
                if stack_s[index] == "[":
                    del stack_s[index]
                    index = index -1
                    continue
                else: return False
            elif i == "]" and len(stack_s) ==0:
                return False
            if i == "}" and len(stack_s) > 0:
                if stack_s[index] == "{":
                    del stack_s[index]
                    index = index -1
                    continue
                else: return False
            elif i == "}" and len(stack_s) ==0:
                return False
        if len(stack_s) == 0:
            return True
        else: return False
