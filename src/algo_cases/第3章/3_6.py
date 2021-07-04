class Solution:
    def longestequence(self, s1, s2):
        len1=len(s1)
        len2=len(s2)
        array=[[0]*(len2+1) for _ in range(len1+1)]
        for i in range(1,len1+1):
            for j in range(1,len2+1):
                if s1[i-1]==s2[j-1]:
                    array[i][j]=array[i-1][j-1]+1
                else:
                    array[i][j]=max(array[i][j-1],array[i-1][j])
        return array[len1][len2]
