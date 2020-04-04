class Solution(object):
    def removeDuplicates(self, S):
        """
        :type S: str
        :rtype: str
        """
        stack_s = []
        index = -1
        for i in S:
            if index ==-1:
                stack_s.append(i)
                index = index + 1
                continue
            else:
                if i == stack_s[index]:
                    del stack_s[index]
                    index = index -1
                else:
                    stack_s.append(i)
                    index = index + 1
        return "".join(stack_s)